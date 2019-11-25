	package com.canteen.common.vo;

import java.io.Serializable;
import java.util.List;

    public class PageObject<T> implements Serializable {
        private Integer  pageCount;	//总页数
        private Integer currentPage=1;//当前页数
        private Integer rows;//总记录数
        private Integer pageSize=4;//页面大小，就是每页有多少条记录
        private List<T>records;//当前页记录
        public Integer getRows() {
            return rows;
        }
        public void setRows(Integer rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "PageObject [pageCount=" + pageCount + ", currentPage=" + currentPage + ", rows=" + rows + ", pageSize="
                    + pageSize + ", records=" + records + "]";
        }


        public Integer getPageCount() {
            return pageCount;
        }
        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }
        public Integer getCurrentPage() {
            return currentPage;
        }
        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }
        public Integer getPageSize() {
            return pageSize;
        }
        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
        public List<T> getRecords() {
            return records;
        }
        public void setRecords(List<T> records) {
            this.records = records;
        }



        }
