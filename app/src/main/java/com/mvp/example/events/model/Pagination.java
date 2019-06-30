package com.mvp.example.events.model;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("page_number")
    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public Pagination(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
