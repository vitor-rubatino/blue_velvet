package com.bluevelvet.web.repositories;

import com.bluevelvet.web.entities.Role;
import com.bluevelvet.web.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByRoleName(RoleName roleName);
}