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

import Users.entity.Roles;

import Users.serviceImpl.RolesServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RolesServiceImpl rolesServiceImpl;

	@GetMapping()
	public List<Roles> getAllRoles() {
		return rolesServiceImpl.findAllRoles();
	}

	@PostMapping()
	public String addRoles(@RequestBody Roles roles) {
		rolesServiceImpl.addRoles(roles);
		return "Roles Added Successfuly";
	}

	@GetMapping("/{id}")
	public Roles getRolesById(@PathVariable int id) {
		return rolesServiceImpl.findRolesById(id);
	}

	@PutMapping("/{id}")
	public String updateRoles(@RequestBody Roles roles, @PathVariable int id) {
		rolesServiceImpl.updateRolesById(roles, id);
		return "Roles Updated Succesfully";
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		rolesServiceImpl.deleteRoles(id);
		return "Roles Deleted Succesfully";
	}
}
