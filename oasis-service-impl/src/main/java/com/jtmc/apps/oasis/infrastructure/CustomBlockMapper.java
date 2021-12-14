package com.jtmc.apps.oasis.infrastructure;

import com.jtmc.apps.oasis.domain.Bloque;
import org.apache.ibatis.annotations.Mapper;

import static com.jtmc.apps.oasis.infrastructure.BloqueDynamicSqlSupport.*;
import static com.jtmc.apps.oasis.infrastructure.BloqueDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CustomBlockMapper extends  BloqueMapper {

    default int updateByIdSelective(Bloque record) {
        return update(c ->
                c.set(idchofer).equalToWhenPresent(record::getIdchofer)
                        .set(secuencia).equalToWhenPresent(record::getSecuencia)
                        .set(letra).equalToWhenPresent(record::getLetra)
                        .set(numinicial).equalToWhenPresent(record::getNuminicial)
                        .set(numfinal).equalToWhenPresent(record::getNumfinal)
                        .where(id, isEqualTo(record::getId))
        );
    }
}
