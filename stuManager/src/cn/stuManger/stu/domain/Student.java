/**
 * 
 */
package cn.stuManger.stu.domain;

/**
 * @date 2019Äê5ÔÂ3ÈÕ
 */
public class Student {
	private int id;
	private String uid;
	private String pwd;
	private String img;
	private String tname;
	private String sex;
	private String tel;
	private String clazz;
	private String address;
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
	public Student(int id, String uid, String pwd, String img, String tname,
			String sex, String tel, String clazz, String address) {
		super();
		this.id = id;
		this.uid = uid;
		this.pwd = pwd;
		this.img = img;
		this.tname = tname;
		this.sex = sex;
		this.tel = tel;
		this.clazz = clazz;
		this.address = address;
	}
	/**
	 * 
	 */
	public Student() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", uid=" + uid + ", pwd=" + pwd + ", img="
				+ img + ", tname=" + tname + ", sex=" + sex + ", tel=" + tel
				+ ", clazz=" + clazz + ", address=" + address + "]";
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
	public String getClazz() {
		return clazz;
	}
	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
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
