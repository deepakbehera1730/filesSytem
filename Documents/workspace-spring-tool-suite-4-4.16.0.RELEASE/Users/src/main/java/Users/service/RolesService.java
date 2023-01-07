package Users.service;

import java.util.List;

import Users.entity.Roles;

public interface RolesService {
	public List<Roles> findAllRoles();

	public Roles addRoles(Roles role);

	public Roles findRolesById(int id);

	public Roles updateRolesById(Roles roles, int id);

	public void deleteRoles(int id);
}
