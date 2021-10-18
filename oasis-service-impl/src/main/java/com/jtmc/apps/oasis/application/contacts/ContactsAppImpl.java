package com.jtmc.apps.oasis.application.contacts;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Contacto;
import com.jtmc.apps.oasis.infrastructure.ContactoMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import java.util.List;
import java.util.Optional;

public class ContactsAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<Contacto> selectAllRows() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ContactoMapper mapper = session.getMapper(ContactoMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }

    public Optional<Contacto> selectOne(int contactId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ContactoMapper mapper = session.getMapper(ContactoMapper.class);
            return mapper.selectByPrimaryKey(contactId);
        }
    }
}
