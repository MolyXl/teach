package cn.teach.common.mvc;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = 8990326177448745629L;
	private T data;
	private List<T> dataList;
	private Integer pageNow;
	private int pageSize;
	private long totalCount;
	private int totalPageCount;

	public PageResult(){
		super();
	}
	/**
	 * 通过构造函数 传入 总记录数 和 当前页
	 * @param totalCount
	 * @param pageNow
	 */
	public PageResult(List<T> dataList, long totalCount, Integer pageNow, Integer pageSize) {
		this.dataList = dataList;
		this.totalCount = totalCount;
		this.pageNow = pageNow;
		this.pageSize = pageSize;
        this.totalPageCount = getTotalPageCount();
    }

    public PageResult(List<T> dataList, long totalCount, int pageSize) {
        this.dataList = dataList;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPageCount = getTotalPageCount();
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
	 * 取得总页数，总页数=总记录数/每页显示的条数
	 * @return
	 */
	public int getTotalPageCount() {
		totalPageCount = (int) (getTotalCount() / getPageSize());
		return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
