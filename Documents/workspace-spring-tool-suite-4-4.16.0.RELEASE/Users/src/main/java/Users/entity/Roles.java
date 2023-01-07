package Users.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String roleName;

	@OneToOne(mappedBy = "roles")
	private User user;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "roles_permission", joinColumns = @JoinColumn(name = "roles_ids"), inverseJoinColumns = @JoinColumn(name = "permissions_id"))
	private Permission permission;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public Roles(int roleId, String roleName, Permission permission) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.permission = permission;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
