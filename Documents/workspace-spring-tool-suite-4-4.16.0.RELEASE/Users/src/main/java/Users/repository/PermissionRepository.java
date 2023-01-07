package Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Users.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
