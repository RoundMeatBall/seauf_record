package com.seauf.controller.model;

import java.util.List;

public class PageModel<T> {

    private Long total;

    private List<T> records;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
