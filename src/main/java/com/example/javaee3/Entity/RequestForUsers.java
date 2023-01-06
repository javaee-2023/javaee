package com.example.javaee3.Entity;

public class RequestForUsers {
    private String query;
    private int pageSize;
    private int pageNum;

    @Override
    public String toString() {
        return "RequestForUsers{" +
                "query='" + query + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
