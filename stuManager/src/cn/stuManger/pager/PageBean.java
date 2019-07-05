package cn.stuManger.pager;

import java.util.List;

/**
 * @���� : ����
 * @���� : 2019��4��23��
 */
public class PageBean<T> {
//	private int tp;//��ҳ��
	private int pd;//��ǰҳ��
	private int tr;//�ܼ�¼��
	private int ps;//ÿҳ��¼��
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
