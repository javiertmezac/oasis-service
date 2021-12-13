package com.jtmc.apps.oasis.api.v1.blocks;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.blocks.BlockAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.domain.Bloque;
import com.jtmc.apps.oasis.domain.Trabajador;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.time.Instant;
import java.util.Locale;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class BlockApiImpl implements BlockApi {

    @Inject
    private BlockAppImpl blockApp;

    @Inject
    private EmployeesAppImpl employeesApp;

    @Override
    public Response createBlock(BlockRequest blockRequest) {
        checkNotNull(blockRequest, "BlockRequest should no be null");
        checkArgument(StringUtils.isNotBlank(blockRequest.getLetter()), "Invalid Letter");
        checkArgument(blockRequest.getEmployeeId() > 0, "Invalid Employee");
        checkArgument(blockRequest.getEndNumber() > 0,
                "Invalid EndNumber, must be greater than 0");
        checkArgument(blockRequest.getEndNumber() > blockRequest.getStartNumber(),
                "Invalid Assignation for Start and End numbers");

        Optional<Trabajador> employee = employeesApp.selectOne(blockRequest.getEmployeeId());
        if (!employee.isPresent()) {
            System.out.printf("EmployeeId %d Not Found.%n", blockRequest.getEmployeeId());
            throw new WebApplicationException("Employee Not Found", Response.Status.NOT_FOUND);
        }

        //todo: if employee already has a block, reject the request

        String blockDetails = String.format("Letter: %s, StartNumber: %d, EndNumber: %d",
                blockRequest.getLetter(), blockRequest.getStartNumber(), blockRequest.getEndNumber());
        System.out.printf("About to create new Block %s for EmployeeId: %d.%n",
                blockDetails, blockRequest.getEmployeeId());

        Bloque b = new Bloque();
        b.setIdchofer(blockRequest.getEmployeeId());
        b.setLetra(blockRequest.getLetter().trim().toUpperCase());
        b.setNuminicial(blockRequest.getStartNumber());
        b.setNumfinal(blockRequest.getEndNumber());
        b.setSecuencia(blockRequest.getStartNumber());
        b.setFecharegistro(Instant.now());
        int result = blockApp.insertBlock(b);
        if(result != 1) {
            System.out.printf("Block %s was not registered.%n", blockDetails);
            throw new WebApplicationException("Block not registered", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("Block %s successfully created.%n", blockDetails);

        return Response.ok().build();
    }

    @Override
    public BlockResponse getBlock(int blockId) {
        checkArgument(blockId > 0, "Invalid BlockId");
        Optional<Bloque> block = blockApp.selectOne(blockId);
        if (!block.isPresent()) {
            System.out.printf("Block %d not found.%n", blockId);
            throw new WebApplicationException("Block Not Found", Response.Status.NOT_FOUND);
        }

        BlockResponse blockResponse = new BlockResponse();
        blockResponse.setBlockId(block.get().getId());
        blockResponse.setEndNumber(String.valueOf(block.get().getNumfinal()));
        blockResponse.setStartNumber(String.valueOf(block.get().getNuminicial()));
        blockResponse.setLetter(block.get().getLetra());
        blockResponse.setNextBlockNumber(String.valueOf(block.get().getSecuencia()));
        return blockResponse;
    }

    @Override
    public Response deleteMarkBlock(int blockId) {
        checkArgument(blockId != 0, "Invalid BlockId");

        Optional<Bloque> block = blockApp.selectOne(blockId);
        if (!block.isPresent()) {
            System.out.printf("Block #%d not found. %n", blockId);
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        if (blockApp.deleteMarkBlock(block.get()) != 1) {
            System.out.printf("Not able to update / delete mark correctly: BlockId %d.%n", blockId);
            throw new WebApplicationException("Internal Error", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.printf("Delete marked successfully on blockID: %d.%n", blockId);
        return Response.ok().build();
    }
}
