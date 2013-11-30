/**
 * 分页bean
 */

package com.jackge.domain;

import java.util.ArrayList;

public class PageBean {

	//pageNow   pageSize  pageCount  
	private int pageNow;
	private int pageCount;
	private int pageSize;
	private int rowCount;	//表示共有多少条记录
	//al中就是真的要显示的信息
	private ArrayList al = new ArrayList();
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public ArrayList getAl() {
		return al;
	}
	public void setAl(ArrayList al) {
		this.al = al;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
}
