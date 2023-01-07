package Users.repository;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Users.entity.Roles;

@Repository
public interface RoleRepaository extends JpaRepository<Roles, Integer> {

}
