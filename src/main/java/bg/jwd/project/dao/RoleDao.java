package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Role;

public interface RoleDao {

    int addRole(String role);

    Role getRole(int Id);

    Role getRole(String roleName);

    List<Role> getAllRole();
}
