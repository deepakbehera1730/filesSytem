package Users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Users.entity.Permission;
import Users.serviceImpl.PermissionServiceImpl;
@RestController
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionServiceImpl permissionServiceImpl;

	@GetMapping()
	public List<Permission> getAllPermission() {
		return permissionServiceImpl.findAllPermission();
	}

	@PostMapping()
	public String addPermission(@RequestBody Permission permission) {
		permissionServiceImpl.addPermission(permission);
		return "Permission Added Successfuly";
	}

	@GetMapping("/{id}")
	public Permission getPermissionById(@PathVariable int id) {
		return permissionServiceImpl.findPermissionlesById(id);
	}

	@PutMapping("/{id}")
	public String updatePermission(@RequestBody Permission permission, @PathVariable int id) {
		permissionServiceImpl.updatePermissionById(permission, id);
		return "Permission Updated Succesfully";
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		permissionServiceImpl.deletePermission(id);
		return "Permission Deleted Succesfully";
	}
}
