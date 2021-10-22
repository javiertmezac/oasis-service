package com.jtmc.apps.oasis.application.users;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.infrastructure.UsersMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.Optional;

import static com.jtmc.apps.oasis.infrastructure.UsersDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.select;

public class UserAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<com.jtmc.apps.oasis.domain.Users> selectUser(String inputEmail, String inputPassword) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            SelectStatementProvider statementProvider =
                    select(UsersMapper.selectList, users,
                            c -> c.where(username, isEqualTo(inputEmail))
                                    .and(password, isEqualTo(inputPassword))
                    );

            return mapper.selectOne(statementProvider);
        }
    }
}
