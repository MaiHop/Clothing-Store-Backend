package com.maihop.identify.service.repository;

import com.maihop.identify.service.entity.InvalidatedToken;
import com.maihop.identify.service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {

}
