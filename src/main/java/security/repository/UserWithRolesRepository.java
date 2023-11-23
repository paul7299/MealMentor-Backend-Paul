package security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import security.entity.UserWithRoles;

public interface
UserWithRolesRepository extends JpaRepository<UserWithRoles,String> {
    Boolean existsByEmail(String email);
}
