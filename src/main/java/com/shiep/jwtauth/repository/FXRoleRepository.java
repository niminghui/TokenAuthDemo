package com.shiep.jwtauth.repository;

import com.shiep.jwtauth.entity.FXRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 16:49
 * @description:  FXRole的dao层
 */
@Repository
public interface FXRoleRepository extends JpaRepository<FXRole,Integer> {

}
