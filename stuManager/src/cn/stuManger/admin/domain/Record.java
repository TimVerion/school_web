/**
 * 
 */
package cn.stuManger.admin.domain;

/**
 * @date 2019Äê5ÔÂ6ÈÕ
 */
public class Record {
	private int id;
	private String name;
	private String tname;
	private String filer;
	private String pubtime;
	/**
	 * @param id
	 * @param name
	 * @param tname
	 * @param filer
	 * @param note
	 * @param pubtime
	 */
	public Record(int id, String name, String tname, String filer,
			String pubtime) {
		super();
		this.id = id;
		this.name = name;
		this.tname = tname;
		this.filer = filer;
		this.pubtime = pubtime;
	}
	/**
	 * 
	 */
	public Record() {
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
	 * @return the filer
	 */
	public String getFiler() {
		return filer;
	}
	/**
	 * @param filer the filer to set
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	/**
	 * @return the note
	 */
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
		return "Record [id=" + id + ", name=" + name + ", tname=" + tname
				+ ", filer=" + filer + ", pubtime=" + pubtime
				+ "]";
	}
	
}
