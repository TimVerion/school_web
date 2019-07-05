/**
 * 
 */
package cn.stuManger.teacher.domain;

/**
 * @date 2019Äê5ÔÂ3ÈÕ
 */
public class Teacher {
	private int id;
	private String uid;
	private String pwd;
	private String img;
	private String tname;
	private String sex;
	private String tel;
	private String address;
	private String utype;
	/**
	 * @param id
	 * @param uid
	 * @param pwd
	 * @param img
	 * @param tname
	 * @param sex
	 * @param tel
	 * @param clazz
	 * @param address
	 */
	public Teacher(int id, String uid, String pwd, String img, String tname,
			String sex, String tel, String address ,String utype) {
		super();
		this.id = id;
		this.uid = uid;
		this.pwd = pwd;
		this.img = img;
		this.tname = tname;
		this.sex = sex;
		this.tel = tel;
		this.utype = utype;
		this.address = address;
	}
	/**
	 * 
	 */
	public Teacher() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", uid=" + uid + ", pwd=" + pwd + ", img="
				+ img + ", tname=" + tname + ", sex=" + sex + ", tel=" + tel
				+ ", utype=" + utype + ", address=" + address + "]";
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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the clazz
	 */
	public String getUtype() {
		return utype;
	}
	/**
	 * @param clazz the clazz to set
	 */
	public void setUtype(String utype) {
		this.utype = utype;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
