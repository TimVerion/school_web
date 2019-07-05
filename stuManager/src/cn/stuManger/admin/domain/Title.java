/**
 * 
 */
package cn.stuManger.admin.domain;

/**
 * @date 2019Äê5ÔÂ6ÈÕ
 */
public class Title {
	private int id;
	private String tname;
	private String img;
	private String name;
	private String pubtime;
	/**
	 * @param id
	 * @param tname
	 * @param img
	 * @param name
	 * @param pubtime
	 */
	public Title(int id, String tname, String img, String name, String pubtime) {
		super();
		this.id = id;
		this.tname = tname;
		this.img = img;
		this.name = name;
		this.pubtime = pubtime;
	}
	/**
	 * 
	 */
	public Title() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pubtime
	 */
	public String getPubtime() {
		return pubtime;
	}
	/**
	 * @param pubtime the pubtime to set
	 */
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Title [id=" + id + ", tname=" + tname + ", img=" + img
				+ ", name=" + name + ", pubtime=" + pubtime + "]";
	}
	
}
