package com.jtmc.apps.oasis.application.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v2.Pageable;
import com.jtmc.apps.oasis.domain.CustomNote;
import com.jtmc.apps.oasis.domain.Nota;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.mybatis.dynamic.sql.select.join.JoinCriterion;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.mybatis.dynamic.sql.where.condition.IsLike;

import java.util.List;
import java.util.Optional;

public class NotesAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<CustomNote> selectAllRecords() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomNoteMapper mapper = session.getMapper(CustomNoteMapper.class);
            return mapper.selectManyCustomNotes();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching Notes");
        }
    }

    public List<CustomNote> selectPaidNotes(boolean paginatedVersion, Pageable pageable,  String search) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomNoteMapper mapper = session.getMapper(CustomNoteMapper.class);

            String sanitizedSearch = StringUtils.isBlank(search) ? "" : search;
            return paginatedVersion ? mapper.selectPaidNotesSPV2(pageable.getOffset(), pageable.size, sanitizedSearch) : mapper.selectPaidNotesSP();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching PaidNotes");
        }
    }

    public List<CustomNote> selectPaidNotes() {
        return this.selectPaidNotes(false, null, null);
    }

    public Optional<CustomNote> selectOneNote(int noteId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomNoteMapper mapper = session.getMapper(CustomNoteMapper.class);
            return mapper.selectByPrimaryKeyCustomNote(noteId);
        }
    }

    public Optional<Nota> selectNoteByOrderId(int orderId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            NotaMapper mapper = session.getMapper(NotaMapper.class);
            return mapper.selectOne(c -> c.where(NotaDynamicSqlSupport.idpedido, SqlBuilder.isEqualTo(orderId))
                    .and(NotaDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }

    public int insertNote(Nota note) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            NotaMapper mapper = session.getMapper(NotaMapper.class);
            note.setStatus(true);
            return mapper.insertSelective(note);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int updateNote(Nota note) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            NotaMapper mapper = session.getMapper(NotaMapper.class);
            return mapper.updateByPrimaryKeySelective(note);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int deleteMarkNote(int noteId) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            NotaMapper mapper = session.getMapper(NotaMapper.class);

            Nota n = new Nota();
            n.setId(noteId);
            n.setStatus(false);

            return mapper.updateByPrimaryKeySelective(n);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public long countActive(String search) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            NotaMapper mapper = session.getMapper(NotaMapper.class);
            String sanitizedSearch = StringUtils.isBlank(search) ? "%%" : "%" + search + "%";

            JoinCriterion.Builder pedidoBuilder = new JoinCriterion.Builder();
            pedidoBuilder.withConnector("on").withJoinColumn(NotaDynamicSqlSupport.idpedido).withJoinCondition(new EqualTo(PedidoDynamicSqlSupport.id));

            JoinCriterion.Builder empresaBuilder = new JoinCriterion.Builder();
            empresaBuilder.withConnector("on").withJoinColumn(PedidoDynamicSqlSupport.idempresa).withJoinCondition(new EqualTo(EmpresaDynamicSqlSupport.id));

            CountDSLCompleter completer = c ->
                    c.leftJoin(PedidoDynamicSqlSupport.pedido, pedidoBuilder.build())
                            .leftJoin(EmpresaDynamicSqlSupport.empresa, empresaBuilder.build())
                            .where( NotaDynamicSqlSupport.status, SqlBuilder.isTrue())
                            .and(
                                    EmpresaDynamicSqlSupport.nombre, IsLike.of(sanitizedSearch),
                                    SqlBuilder.or(NotaDynamicSqlSupport.nonota, IsLike.of(sanitizedSearch))
                            );
            SelectStatementProvider statement = MyBatis3Utils.countFrom(NotaDynamicSqlSupport.nota, completer);
            return mapper.count(statement);
        }
    }

    public int totalPages(long totalItems, int size) {
        return (int) Math.ceil((double) totalItems / size);
    }
}
