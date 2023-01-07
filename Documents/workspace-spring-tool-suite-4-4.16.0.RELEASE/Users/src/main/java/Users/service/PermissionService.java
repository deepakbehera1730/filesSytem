package Users.service;

import java.util.List;

import Users.entity.Permission;
import Users.entity.Roles;

public interface PermissionService {
	public List<Permission> findAllPermission();

	public Permission addPermission(Permission permission);

	public Permission findPermissionlesById(int id);

	public Permission updatePermissionById(Permission permission, int id);

	public void deletePermission(int id);
}
