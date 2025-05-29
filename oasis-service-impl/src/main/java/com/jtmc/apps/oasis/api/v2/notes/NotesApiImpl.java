package com.jtmc.apps.oasis.api.v2.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.api.v1.notes.NoteConverterToNotesResponse;
import com.jtmc.apps.oasis.api.v1.notes.NotesConverter;
import com.jtmc.apps.oasis.api.v1.notes.NotesResponse;
import com.jtmc.apps.oasis.api.v2.Pageable;
import com.jtmc.apps.oasis.api.v2.Pagination;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.domain.CustomNote;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JWTRequired
public class NotesApiImpl implements NotesApi {
    @Inject
    private NotesAppImpl repository;

    @Inject
    private NotesConverter notesConverter;

    @Inject
    private NoteConverterToNotesResponse converterToNotesResponse;

    @Override
    public PaginatedNotesResponse getNotes(boolean selectPaidNotes, int page, int size, String search) {
        List<CustomNote> noteList;
        Pagination pagination = null;
        long totalItems = 0;
        if (selectPaidNotes) {
            Pageable p = new Pageable(page,size);
            noteList = repository.selectPaidNotes(true, p, search);
            totalItems = repository.countActive(search);
        } else {
            noteList = repository.selectAllRecords();
            totalItems = noteList.size();
        }

        Stream<NotesResponse> noteResponseStream =
                noteList.stream().map(n -> converterToNotesResponse.apply(n));

        int totalPages = repository.totalPages(totalItems, size);
        pagination = new Pagination(page, size,  totalPages, totalItems);

        PaginatedNotesResponse r = new PaginatedNotesResponse();
        r.setNotesResponse(noteResponseStream.collect(Collectors.toList()));
        r.setPagination(pagination);

        return r;
    }
}
