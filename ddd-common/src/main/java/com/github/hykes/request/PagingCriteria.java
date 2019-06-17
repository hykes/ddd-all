package com.github.hykes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 15:00:00
 */
@SuppressWarnings("all")
public class PagingCriteria extends Criteria implements Serializable {
    private static final long serialVersionUID = 2598875146576926658L;
    public static final int SORT_TYPE_ASC = 1;
    public static final int SORT_TYPE_DESC = 2;


    /**
     * 分页号, 从1开始
     */
    @JsonIgnore
    protected Integer pageNo = 1;

    /**
     * 分页大小
     */
    @JsonIgnore
    protected Integer pageSize = 20;

    /**
     * 是否还有下一页
     */
    @JsonIgnore
    protected Boolean hasNext = true;

    /**
     * 是否跳过计数,直接返回列表(使用于只缓存计数器的场景)
     */
    protected Boolean skipCount;

    /**
     * 排序字段
     */
    protected String sortBy;

    /**
     * 排序类型 1-ASC 2-DESC
     */
    protected Integer sortType;

    @JsonIgnore
    public Boolean hasNext() {
        return this.hasNext;
    }


    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }


    public MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("pageNo", pageNo)
                .add("pageSize", pageSize)
                .add("hasNext", hasNext)
                .add("skipCount", skipCount)
                .add("sortBy", sortBy)
                .add("sortType", sortType);
    }


    /**
     * 跳转到下一页
     */
    public void nextPage() {
        if (pageNo == null) {
            pageNo = 1;
        }
        pageNo += 1;
    }

    /**
     * 分页大小, 默认20, 用于数据库
     */
    public Integer getLimit() {
        PageInfo pageInfo = new PageInfo(pageNo, pageSize);
        return pageInfo.getLimit();
    }

    /**
     * 分页起始, 从0开始, 用于数据库
     */
    public Integer getOffset() {
        PageInfo pageInfo = new PageInfo(pageNo, pageSize);
        return pageInfo.getOffset();
    }

    @Override
    public Map<String, Object> toMap() {
        return super.toMap();
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public Boolean getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(Boolean skipCount) {
        this.skipCount = skipCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PagingCriteria)) {
            return false;
        }
        PagingCriteria other = (PagingCriteria) o;
        if (!Objects.equals(this.pageNo, other.pageNo)) {
            return false;
        }
        if (!Objects.equals(this.pageSize, other.pageSize)) {
            return false;
        }
        if (!Objects.equals(this.hasNext, other.hasNext)) {
            return false;
        }
        if (!Objects.equals(this.sortBy, other.sortBy)) {
            return false;
        }
        if (!Objects.equals(this.sortType, other.sortType)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result * PRIME) + (this.pageNo == null ? 0 : this.pageNo);
        result = (result * PRIME) + (this.pageSize == null ? 0 : this.pageSize);
        result = (result * PRIME) + (this.hasNext == null ? 0 : this.hasNext.hashCode());
        result = (result * PRIME) + (this.sortBy == null ? 0 : this.sortBy.hashCode());
        result = (result * PRIME) + (this.sortType == null ? 0 : this.sortType.hashCode());
        return result;
    }
}
