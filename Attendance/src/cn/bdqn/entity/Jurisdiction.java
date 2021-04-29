package cn.bdqn.entity;

public class Jurisdiction {
	//id  button  qname parentid  type url js  isdelete
	private int id;//权限id
	private String button;//权限按钮
	private String qname;//权限名
	private int parentid;//父级权限id
	private int type;//权限类型
	private String url;//权限请求地址
	private String js;//权限对应js
	private int isdelete;//伪删除
	
	public Jurisdiction() {}
	
	public Jurisdiction(int id, String button, String qname, int parentid, int type, String url, String js,
			int isdelete) {
		super();
		this.id = id;
		this.button = button;
		this.qname = qname;
		this.parentid = parentid;
		this.type = type;
		this.url = url;
		this.js = js;
		this.isdelete = isdelete;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	
	@Override
	public String toString() {
		return "Jurisdiction [id=" + id + ", button=" + button + ", qname=" + qname + ", parentid=" + parentid
				+ ", type=" + type + ", url=" + url + ", js=" + js + ", isdelete=" + isdelete + ", getId()=" + getId()
				+ ", getButton()=" + getButton() + ", getQname()=" + getQname() + ", getParentid()=" + getParentid()
				+ ", getType()=" + getType() + ", getUrl()=" + getUrl() + ", getJs()=" + getJs() + ", getIsdelete()="
				+ getIsdelete() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
