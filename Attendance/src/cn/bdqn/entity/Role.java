package cn.bdqn.entity;
/**
   * 角色
 * @author Lenovo
 *
 */
public class Role {
	//id  role  
	private int id;//角色id
	private String role;//角色类型
	
	public Role() {}
	
	
	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", getId()=" + getId() + ", getRole()=" + getRole()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
