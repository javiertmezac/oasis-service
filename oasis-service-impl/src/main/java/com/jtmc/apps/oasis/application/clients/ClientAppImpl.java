package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v2.Pageable;
import com.jtmc.apps.oasis.api.v2.clients.ClientsApiImpl;
import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.CustomClientMapper;
import com.jtmc.apps.oasis.infrastructure.EmpresaDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import com.jtmc.apps.oasis.infrastructure.PreciogranelDynamicSqlSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.*;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.mybatis.dynamic.sql.where.condition.IsLike;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientAppImpl {

    private final Logger logger = LoggerFactory.getLogger(ClientsApiImpl.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    /***
     * Validates a given clientId exists in DB
     * @param clientId Client Identifier
     * @return CustomClient if it is present in DB
     * @throws WebApplicationException when CustomClient is not Present
     */
    public CustomClient validateCustomClientExists(int clientId) {
        Optional<CustomClient> client = this.selectOne(clientId);
        if (!client.isPresent()) {
            logger.info("Client Not Found, {}", clientId);
            throw new WebApplicationException("Not Found", Response.Status.NOT_FOUND);
        }
        return  client.get();
    }

    public List<CustomClient> selectAllRows() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);
            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addBasicColumns(), EmpresaDynamicSqlSupport.empresa,
                            c -> c.join(PreciogranelDynamicSqlSupport.preciogranel)
                                    .on(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.equalTo(PreciogranelDynamicSqlSupport.id))
                                    .where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                    );
            return mapper.selectManyCustomClient(statementProvider);
        }
    }

    public Optional<CustomClient> selectOne(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addBasicColumns(), EmpresaDynamicSqlSupport.empresa,
                            c -> c.join(PreciogranelDynamicSqlSupport.preciogranel)
                                    .on(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.equalTo(PreciogranelDynamicSqlSupport.id))
                                    .where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                                    .and(EmpresaDynamicSqlSupport.id, SqlBuilder.isEqualTo(clientId))
                    );
            return mapper.selectOneCustomClient(statementProvider);
        }
    }

    private BasicColumn[] addBasicColumns() {
        ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(EmpresaMapper.selectList));
        list.add(PreciogranelDynamicSqlSupport.precio.as("price"));

        return BasicColumn.columnList(list.toArray(new BasicColumn[0]));
    }

    public int insertClient(Empresa client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            client.setStatus(true);
            return mapper.insertSelective(client);
        } catch (Exception ex) {
            logger.error("", ex);
            throw ex;
        }
    }

    public int updateSelective(Empresa client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.updateByPrimaryKeySelective(client);
        } catch (Exception ex) {
            logger.error("", ex);
            throw ex;
        }
    }

    public int deleteMarkSelective(Empresa client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            client.setStatus(false);
            return mapper.updateByPrimaryKeySelective(client);
        } catch (Exception ex) {
            logger.error("", ex);
            throw ex;
        }
    }

    public List<Empresa> selectAllRecordsWithPriceId(byte priceId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.select(c -> c.where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                    .and(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.isEqualTo(priceId))
            );
        }
    }

    public List<CustomClient> selectClientsNotRecentOrders() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);
            return mapper.selectViewNotOrderIn30Days();
        } catch (Exception ex) {
            logger.error("", ex);
            throw ex;
        }
    }

    public long countActiveClients() {
        return this.countActiveClients(null);
    }

    public long countActiveClients(String search) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            String sanitizedSearch = StringUtils.isBlank(search) ? "%%" : "%" + search + "%";

            CountDSLCompleter completer = c -> c.where( EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                    .and(
                            EmpresaDynamicSqlSupport.nombre, IsLike.of(sanitizedSearch),
                            SqlBuilder.or(EmpresaDynamicSqlSupport.calle, IsLike.of(sanitizedSearch)),
                            SqlBuilder.or(EmpresaDynamicSqlSupport.colonia, IsLike.of(sanitizedSearch))
                    );
            SelectStatementProvider statement = MyBatis3Utils.countFrom(EmpresaDynamicSqlSupport.empresa, completer);
            return mapper.count(statement);
        }
    }

    public List<CustomClient> findAll(Pageable pageable, String search) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);

            String sanitizedSearch = StringUtils.isBlank(search) ? "%%" : "%" + search + "%";

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addBasicColumns(), EmpresaDynamicSqlSupport.empresa,
                            c -> c.join(PreciogranelDynamicSqlSupport.preciogranel)
                                    .on(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.equalTo(PreciogranelDynamicSqlSupport.id))
                                    .where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                                    .and(
                                            EmpresaDynamicSqlSupport.nombre, IsLike.of(sanitizedSearch),
                                            SqlBuilder.or(EmpresaDynamicSqlSupport.calle, IsLike.of(sanitizedSearch)),
                                            SqlBuilder.or(EmpresaDynamicSqlSupport.colonia, IsLike.of(sanitizedSearch))
                                    )
                                    .orderBy(SqlColumn.of(EmpresaDynamicSqlSupport.fecharegistro.name(), EmpresaDynamicSqlSupport.empresa).descending())
                                    .offset(pageable.getOffset())
                                    .fetchFirst(pageable.size).rowsOnly()
                    );

            return mapper.selectManyCustomClient(statementProvider);
        }
    }

    public int totalPages(long totalItems, int size) {
        return (int) Math.ceil((double) totalItems / size);
    }

}
