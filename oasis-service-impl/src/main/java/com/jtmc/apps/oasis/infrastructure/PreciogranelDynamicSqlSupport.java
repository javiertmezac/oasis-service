package com.jtmc.apps.oasis.infrastructure;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PreciogranelDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.005216-08:00", comments="Source Table: PrecioGranel")
    public static final Preciogranel preciogranel = new Preciogranel();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.005877-08:00", comments="Source field: PrecioGranel.id")
    public static final SqlColumn<Byte> id = preciogranel.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.006361-08:00", comments="Source field: PrecioGranel.precio")
    public static final SqlColumn<Double> precio = preciogranel.precio;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-10T10:12:04.005471-08:00", comments="Source Table: PrecioGranel")
    public static final class Preciogranel extends SqlTable {
        public final SqlColumn<Byte> id = column("id", JDBCType.TINYINT);

        public final SqlColumn<Double> precio = column("precio", JDBCType.DECIMAL);

        public Preciogranel() {
            super("PrecioGranel");
        }
    }
}