package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ClientCleaningTankDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.570248-08:00", comments="Source Table: ClientCleaningTankRecord")
    public static final ClientCleaningTank clientCleaningTank = new ClientCleaningTank();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.570709-08:00", comments="Source field: ClientCleaningTankRecord.id")
    public static final SqlColumn<Integer> id = clientCleaningTank.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.571094-08:00", comments="Source field: ClientCleaningTankRecord.clientId")
    public static final SqlColumn<Integer> clientid = clientCleaningTank.clientid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.571243-08:00", comments="Source field: ClientCleaningTankRecord.tankCleaningDate")
    public static final SqlColumn<Instant> tankcleaningdate = clientCleaningTank.tankcleaningdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.571338-08:00", comments="Source field: ClientCleaningTankRecord.comments")
    public static final SqlColumn<String> comments = clientCleaningTank.comments;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.571426-08:00", comments="Source field: ClientCleaningTankRecord.status")
    public static final SqlColumn<Boolean> status = clientCleaningTank.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-12-15T22:23:56.570523-08:00", comments="Source Table: ClientCleaningTankRecord")
    public static final class ClientCleaningTank extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> clientid = column("clientId", JDBCType.INTEGER);

        public final SqlColumn<Instant> tankcleaningdate = column("tankCleaningDate", JDBCType.DATE);

        public final SqlColumn<String> comments = column("comments", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public ClientCleaningTank() {
            super("ClientCleaningTankRecord");
        }
    }
}