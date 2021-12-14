package com.jtmc.apps.oasis.api.v1.blocks;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.application.blockerror.BlockErrorAppImpl;
import com.jtmc.apps.oasis.application.blocks.BlockAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.application.users.UserAppImpl;
import com.jtmc.apps.oasis.domain.Bloque;
import com.jtmc.apps.oasis.domain.Serieerror;
import com.jtmc.apps.oasis.domain.Trabajador;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JWTRequired
public class BlockApiImpl implements BlockApi {

    @Inject
    private BlockAppImpl blockApp;

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private UserAppImpl userApp;

    @Inject
    private BlockErrorAppImpl blockErrorApp;

    @Override
    public Response createBlock(BlockRequest blockRequest) {
        checkNotNull(blockRequest, "BlockRequest should no be null");
        int newBlock = 0;
        checkArgument(blockRequest.getBlockId() == newBlock , "Invalid BlockId");
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
        userApp.isUserAdmin();

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
        System.out.printf("Delete marked successfully on blockId: %d.%n", blockId);

        String affectedNote = String.format("%s - %d", block.get().getLetra(), block.get().getSecuencia());
        String comments = String.format("ADMIN Request. Block %s %d - %d was delete marked",
                block.get().getLetra(), block.get().getNuminicial(), block.get().getNumfinal());
        insertBlockError(comments, affectedNote, block.get().getIdchofer());

        return Response.ok().build();
    }

    @Override
    public Response updateBlock(BlockRequest blockRequest) {

        userApp.isUserAdmin();

        checkNotNull(blockRequest, "Invalid BlockRequest");
        int newBlock = 0;
        checkArgument(blockRequest.getBlockId() != newBlock, "Invalid Block");
        checkArgument(StringUtils.isNotBlank(blockRequest.getLetter()), "Invalid Letter");
        checkArgument(blockRequest.getEmployeeId() > 0, "Invalid Employee");
        checkArgument(blockRequest.getEndNumber() > 0,
                "Invalid EndNumber, must be greater than 0");
        checkArgument(blockRequest.getEndNumber() > blockRequest.getStartNumber(),
                "Invalid Assignation for Start and End numbers");

        checkArgument(blockRequest.getNextBlockNumber() >= blockRequest.getStartNumber() &&
                blockRequest.getNextBlockNumber() <= blockRequest.getEndNumber(),
                "Invalid NextBlockNumber");

        Optional<Bloque> block = blockApp.selectOne(blockRequest.getBlockId());
        if(!block.isPresent()){
            System.out.printf("Block not found #%d.%n", blockRequest.getBlockId());
            throw new WebApplicationException("Block Not Found", Response.Status.NOT_FOUND);
        }

        Bloque blockToUpdate = new Bloque();
        blockToUpdate.setId(block.get().getId());
        blockToUpdate.setLetra(blockRequest.getLetter());
        blockToUpdate.setNuminicial(blockRequest.getStartNumber());
        blockToUpdate.setNumfinal(blockRequest.getEndNumber());
        blockToUpdate.setSecuencia(blockRequest.getNextBlockNumber());
        blockToUpdate.setIdchofer(blockRequest.getEmployeeId());
        if(blockApp.customUpdateBlock(blockToUpdate) != 1) {
            System.out.printf("Not able to update block #%d.%n", blockRequest.getBlockId());
            throw new WebApplicationException("Internal Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("Block #%d updated successfully.%n", blockRequest.getBlockId());

        String affectedNote = String.format("%s - %d",
                block.get().getLetra(), block.get().getSecuencia());
        String affectedBlock = String.format("Affected Block: %s %d - %d",
                block.get().getLetra(), block.get().getNuminicial(), block.get().getNumfinal());

        String blockUpdatedValues = String.format("New Block Values: Block: %s %d - %d, nextBlockNumber: %d",
                blockRequest.getLetter(), blockRequest.getStartNumber(), blockRequest.getEndNumber(),
                blockRequest.getNextBlockNumber());

        String blockDetails = String.format("BlockId #%d for EmployeeId #%d",
                blockRequest.getBlockId(), blockRequest.getEmployeeId());

        String comments = String.format("ADMIN request.\n %s.\n %s was changed to %s", blockDetails,
                affectedBlock, blockUpdatedValues);

        insertBlockError(comments, affectedNote, blockRequest.getEmployeeId());

        return Response.ok().build();
    }

    //todo: refactor
    private void insertBlockError(String comments, String affectedNote, int employeeId) {

        System.out.println("About to create BlockError for tracking purposes");
        Serieerror serieerror = new Serieerror();
        serieerror.setObservaciones(comments);
        serieerror.setNonota(affectedNote);
        serieerror.setIdchofer(employeeId);
        serieerror.setFecharegistro(Instant.now());
        serieerror.setId(null);
        if(blockErrorApp.insertBlockError(serieerror) != 1) {
            System.out.println("Not able to insert BlockError");
            System.out.println(comments);
        }
        System.out.println("BlockError inserted successfully");

    }
}
