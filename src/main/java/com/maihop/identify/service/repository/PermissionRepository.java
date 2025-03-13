package com.maihop.identify.service.repository;

import com.maihop.identify.service.entity.Permission;
import com.maihop.identify.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

}
