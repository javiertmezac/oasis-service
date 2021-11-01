package com.jtmc.apps.oasis.application.orders;
import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomOrder;
import com.jtmc.apps.oasis.domain.Pedido;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.jtmc.apps.oasis.infrastructure.PedidoDynamicSqlSupport.*;

public class OrdersAppImpl {

    //todo: all propagated exceptions should be managed in one generic to properly logged the error message

    final int NOTIFICATION_TERMINATED = 6;

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<CustomOrder> selectNotTerminatedRecords() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            CustomOrderMapper mapper = session.getMapper(CustomOrderMapper.class);

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addColumnToOrderBasicColumns(), pedido,
                            c -> c.join(EmpresaDynamicSqlSupport.empresa, "client")
                                    .on(EmpresaDynamicSqlSupport.id, SqlBuilder.equalTo(PedidoDynamicSqlSupport.idempresa))
                                    .join(TrabajadorDynamicSqlSupport.trabajador, "employee")
                                    .on(TrabajadorDynamicSqlSupport.id, SqlBuilder.equalTo(idchofer))
                                    .where(idnotificacion, SqlBuilder.isNotEqualTo(NOTIFICATION_TERMINATED))
                                    .and(status, SqlBuilder.isTrue())
                    );
            return mapper.selectManyCustomOrders(statementProvider);
        }
    }

    public Optional<CustomOrder> selectOne(int orderId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            CustomOrderMapper mapper = session.getMapper(CustomOrderMapper.class);

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addColumnToOrderBasicColumns(), pedido,
                            c -> c.join(EmpresaDynamicSqlSupport.empresa, "client")
                                    .on(EmpresaDynamicSqlSupport.id, SqlBuilder.equalTo(PedidoDynamicSqlSupport.idempresa))
                                    .join(TrabajadorDynamicSqlSupport.trabajador, "employee")
                                    .on(TrabajadorDynamicSqlSupport.id, SqlBuilder.equalTo(idchofer))
                                    .where(id, SqlBuilder.isEqualTo(orderId))
                    );
            return mapper.selectOneCustomOrder(statementProvider);
        }
    }

    private BasicColumn[] addColumnToOrderBasicColumns(BasicColumn... basicColumns) {

        ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(PedidoMapper.selectList));
        list.add(EmpresaDynamicSqlSupport.nombre.as("clientName"));
        list.add(TrabajadorDynamicSqlSupport.nombre.as("employeeName"));

        if (basicColumns != null && basicColumns.length > 0) {
            list.addAll(Arrays.asList(basicColumns));
        }
        return BasicColumn.columnList(list.toArray(new BasicColumn[0]));
    }

    public int createOrder(Pedido p) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            PedidoMapper mapper = session.getMapper(PedidoMapper.class);

            p.setStatus(true);
            return mapper.insertSelective(p);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Internal Error while inserting new order");
        }
    }

    public int deleteMark(Pedido p) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            PedidoMapper mapper = session.getMapper(PedidoMapper.class);
            return mapper.updateByPrimaryKeySelective(p);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Internal Error while updating/deleting order");
        }
    }

}
