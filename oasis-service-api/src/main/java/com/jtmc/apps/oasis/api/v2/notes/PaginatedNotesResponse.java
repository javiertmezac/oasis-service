package com.jtmc.apps.oasis.api.v2.notes;

import com.jtmc.apps.oasis.api.v1.notes.NotesResponse;
import com.jtmc.apps.oasis.api.v2.Pagination;

import java.util.List;

public class PaginatedNotesResponse {

    private List<NotesResponse> notesResponse;
    private Pagination pagination;

    public List<NotesResponse> getNotesResponse() {
        return notesResponse;
    }

    public void setNotesResponse(List<NotesResponse> notesResponse) {
        this.notesResponse = notesResponse;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
