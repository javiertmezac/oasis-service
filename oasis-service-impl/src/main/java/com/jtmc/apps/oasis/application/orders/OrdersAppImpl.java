package com.jtmc.apps.oasis.application.orders;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Pedido;
import com.jtmc.apps.oasis.infrastructure.PedidoMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrdersAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

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
}
