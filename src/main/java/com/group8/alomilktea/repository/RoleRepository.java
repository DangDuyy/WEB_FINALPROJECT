package com.group8.alomilktea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group8.alomilktea.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
