package Users.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Users.entity.Roles;
import Users.repository.RoleRepaository;
import Users.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RoleRepaository roleRepaository;
	@Override
	public List<Roles> findAllRoles() {
		// TODO Auto-generated method stub
		return  roleRepaository.findAll();
	}

	@Override
	public Roles addRoles(Roles roles) {
		// TODO Auto-generated method stub
		return roleRepaository.save(roles);
	}

	@Override
	public Roles findRolesById(int id) {
		// TODO Auto-generated method stub
		return  roleRepaository.findById(id).orElseThrow();
	}

	@Override
	public Roles updateRolesById(Roles roles, int id) {
		// TODO Auto-generated method stub
		Roles roles1 = roleRepaository.findById(id).orElseThrow();
		roles1.setRoleName(roles.getRoleName());
		roles1.setPermission(roles.getPermission());
		return roleRepaository.save(roles);
	}

	@Override
	public void deleteRoles(int id) {
		// TODO Auto-generated method stub
		roleRepaository.deleteById(id);
	}

}
