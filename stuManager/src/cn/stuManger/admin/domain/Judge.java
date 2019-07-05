/**
 * 
 */
package cn.stuManger.admin.domain;

/**
 * @date 2019年5月5日
 */
//奖学金
public class Judge {
	private int id;
	private String tname;
	private String img;
	private String name;
	private String level;
	private String price;
	private String pubtime;
	/**
	 * @param id
	 * @param tname
	 * @param img
	 * @param name
	 * @param level
	 * @param price
	 * @param pubtime
	 */
	public Judge(int id, String tname, String img, String name, String level,
			String price, String pubtime) {
		super();
		this.id = id;
		this.tname = tname;
		this.img = img;
		this.name = name;
		this.level = level;
		this.price = price;
		this.pubtime = pubtime;
	}
	/**
	 * 
	 */
	public Judge() {
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
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
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
		return "Judge [id=" + id + ", tname=" + tname + ", img=" + img
				+ ", name=" + name + ", level=" + level + ", price=" + price
				+ ", pubtime=" + pubtime + "]";
	}
	
	
}
