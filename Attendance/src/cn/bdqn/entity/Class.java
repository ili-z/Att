package cn.bdqn.entity;

public class Class {
	//id  classname  
	private int id;
	private int classname;
	
	public Class() {}
	
	public Class(int id, int classname) {
		super();
		this.id = id;
		this.classname = classname;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassname() {
		return classname;
	}
	public void setClassname(int classname) {
		this.classname = classname;
	}

	
	@Override
	public String toString() {
		return "Class [id=" + id + ", classname=" + classname + ", getId()=" + getId() + ", getClassname()="
				+ getClassname() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
