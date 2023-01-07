package Users.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;
	private String permissionName;
	@OneToOne(mappedBy = "permission")
	private Roles roles;
	
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permission(int permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
}
