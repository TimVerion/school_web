/**
 * 
 */
package cn.stuManger.admin.domain;

/**
 * @date 2019Äê5ÔÂ6ÈÕ
 */
public class Notice {
	private int ggid;
	private String name;
	private String ggpic;
	private String note;
	/**
	 * @param id
	 * @param name
	 * @param ggpic
	 * @param note
	 */
	public Notice(int ggid, String name, String ggpic, String note) {
		super();
		this.ggid = ggid;
		this.name = name;
		this.ggpic = ggpic;
		this.note = note;
	}
	/**
	 * 
	 */
	public Notice() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getGgid() {
		return ggid;
	}
	/**
	 * @param id the id to set
	 */
	public void setGgid(int ggid) {
		this.ggid = ggid;
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
	 * @return the ggpic
	 */
	public String getGgpic() {
		return ggpic;
	}
	/**
	 * @param ggpic the ggpic to set
	 */
	public void setGgpic(String ggpic) {
		this.ggpic = ggpic;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Notice [ggid=" + ggid + ", name=" + name + ", ggpic=" + ggpic
				+ ", note=" + note + "]";
	}
	
}
