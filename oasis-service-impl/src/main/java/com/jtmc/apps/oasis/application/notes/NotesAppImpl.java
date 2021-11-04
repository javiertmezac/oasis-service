package com.jtmc.apps.oasis.application.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomNote;
import com.jtmc.apps.oasis.domain.Nota;
import com.jtmc.apps.oasis.infrastructure.CustomNoteMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

    public Optional<Nota> selectOneNote(int noteId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomNoteMapper mapper = session.getMapper(CustomNoteMapper.class);
            return mapper.selectByPrimaryKey(noteId);
        }
    }
}
