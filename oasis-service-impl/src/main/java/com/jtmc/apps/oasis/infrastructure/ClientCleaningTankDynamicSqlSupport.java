package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ClientCleaningTankDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.089772-08:00", comments="Source Table: ClientCleaningTank")
    public static final ClientCleaningTank clientCleaningTank = new ClientCleaningTank();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.090253-08:00", comments="Source field: ClientCleaningTank.id")
    public static final SqlColumn<Integer> id = clientCleaningTank.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.090647-08:00", comments="Source field: ClientCleaningTank.clientId")
    public static final SqlColumn<Integer> clientid = clientCleaningTank.clientid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.090768-08:00", comments="Source field: ClientCleaningTank.tankCleaningDate")
    public static final SqlColumn<Instant> tankcleaningdate = clientCleaningTank.tankcleaningdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.090916-08:00", comments="Source field: ClientCleaningTank.comments")
    public static final SqlColumn<String> comments = clientCleaningTank.comments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.091032-08:00", comments="Source field: ClientCleaningTank.registrationDate")
    public static final SqlColumn<Instant> registrationdate = clientCleaningTank.registrationdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.091131-08:00", comments="Source field: ClientCleaningTank.status")
    public static final SqlColumn<Boolean> status = clientCleaningTank.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:52:46.090071-08:00", comments="Source Table: ClientCleaningTank")
    public static final class ClientCleaningTank extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> clientid = column("clientId", JDBCType.INTEGER);

        public final SqlColumn<Instant> tankcleaningdate = column("tankCleaningDate", JDBCType.DATE);

        public final SqlColumn<String> comments = column("comments", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registrationdate = column("registrationDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public ClientCleaningTank() {
            super("ClientCleaningTank");
        }
    }
}