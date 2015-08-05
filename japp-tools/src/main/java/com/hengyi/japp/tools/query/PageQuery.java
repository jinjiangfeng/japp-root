package com.hengyi.japp.tools.query;

public abstract class PageQuery extends Query {

    /**
     * 查询的第一条
     */
    protected int first;
    /**
     * 一页条数
     */
    protected Integer pageSize;
    /**
     * 总条数
     */
    protected long count;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
