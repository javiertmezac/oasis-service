package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UsersDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463058-07:00", comments="Source Table: Users")
    public static final Users users = new Users();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463283-07:00", comments="Source field: Users.id")
    public static final SqlColumn<Integer> id = users.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463421-07:00", comments="Source field: Users.name")
    public static final SqlColumn<String> name = users.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463597-07:00", comments="Source field: Users.username")
    public static final SqlColumn<String> username = users.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463792-07:00", comments="Source field: Users.password")
    public static final SqlColumn<String> password = users.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463933-07:00", comments="Source field: Users.regDate")
    public static final SqlColumn<Date> regdate = users.regdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464078-07:00", comments="Source field: Users.expDate")
    public static final SqlColumn<Date> expdate = users.expdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.464282-07:00", comments="Source field: Users.status")
    public static final SqlColumn<Boolean> status = users.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-16T19:36:29.463174-07:00", comments="Source Table: Users")
    public static final class Users extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Date> regdate = column("regDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expdate = column("expDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Users() {
            super("Users");
        }
    }
}