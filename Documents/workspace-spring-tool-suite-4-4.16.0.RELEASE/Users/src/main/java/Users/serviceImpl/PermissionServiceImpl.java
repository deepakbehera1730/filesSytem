package Users.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Users.entity.Permission;
import Users.repository.PermissionRepository;
import Users.service.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService{
@Autowired
private PermissionRepository permissionRepository;
	@Override
	public List<Permission> findAllPermission() {
		// TODO Auto-generated method stub
		return permissionRepository.findAll();
	}

	@Override
	public Permission addPermission(Permission permission) {
		// TODO Auto-generated method stub
		return permissionRepository.save(permission);
	}

	@Override
	public Permission findPermissionlesById(int id) {
		// TODO Auto-generated method stub
		return permissionRepository.findById(id).orElseThrow();
	}

	@Override
	public Permission updatePermissionById(Permission permission, int id) {
		// TODO Auto-generated method stub
		Permission per=permissionRepository.findById(id).orElseThrow();
		per.setPermissionName(permission.getPermissionName());
		return permissionRepository.save(per);
	}

	@Override
	public void deletePermission(int id) {
		// TODO Auto-generated method stub
		permissionRepository.deleteById(id);
	}

}
