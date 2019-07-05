/**
 * 
 */
package cn.stuManger.admin.domain;

/**
 * @date 2019Äê5ÔÂ5ÈÕ
 */
public class Award {
	private int id;
	private String name;
	private String level;
	private String price;
	private String pubtime;
	/**
	 * @param id
	 * @param name
	 * @param level
	 * @param price
	 * @param pubtime
	 */
	public Award(int id, String name, String level, String price, String pubtime) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.price = price;
		this.pubtime = pubtime;
	}
	/**
	 * 
	 */
	public Award() {
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
		return "Award [id=" + id + ", name=" + name + ", level=" + level
				+ ", price=" + price + ", pubtime=" + pubtime + "]";
	}
	
}
