package com.diaz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diaz
 * @since 2019/2/23 21:48
 */
public class PageBean<T> {
    private Integer currentPage = 0;
    private Integer totalPage = 0;
    private Integer totalCount = 0;
    private Integer pageSize = 15;
    private Integer currentPosition = 0;
    private List<T> beanList = new ArrayList<>(0);

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public Integer getTotalPage() {
        int result = 0;
//        result = totalCount % pageSize > 0 ? totalPage / pageSize + 1 : totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            result = (totalCount / pageSize) + 1;
        } else {
            result = totalCount / pageSize;
        }
        return result;
    }

    public Integer getCurrentPosition() {
        return currentPosition = currentPage > 0 ? ((currentPage - 1) * pageSize) : 0;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", currentPosition=" + currentPosition +
                ", beanList=/r/n" + beanList +
                '}';
    }
}
