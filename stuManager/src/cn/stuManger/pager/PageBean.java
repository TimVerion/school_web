package cn.stuManger.pager;

import java.util.List;

/**
 * @作者 : 老妈
 * @日期 : 2019年4月23日
 */
public class PageBean<T> {
//	private int tp;//总页数
	private int pd;//当前页码
	private int tr;//总记录数
	private int ps;//每页记录数
	private String url;
	private List<T> beanList;
	
	
	public PageBean() {
		super();
	}
	
	public int getTp(){
		if(tr%ps != 0){
			return tr/ps+1;
		}
		return tr/ps;
		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int pr) {
		this.ps = pr;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
	
}
