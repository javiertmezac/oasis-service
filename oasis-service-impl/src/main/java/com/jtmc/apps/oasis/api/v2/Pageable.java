package com.jtmc.apps.oasis.api.v2;

public class Pageable {
    public int page;
    public int size;
    public String sortBy;
    public String sortOrder;

    public Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public Pageable(int page, int size, String sortBy, String sortOrder) {
        this.page = page;
        this.size = size;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public Integer getOffset() {
        return page * size;
    }
}
