package com.shiep.jwtauth.repository;

import com.shiep.jwtauth.entity.FXUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 17:05
 * @description: FXUserRole的dao层
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public interface FXUserRoleRepository extends JpaRepository<FXUserRole,FXUserRole> {
    /**
     * description: 根据用户名和角色名保存用户角色表
     *
     * @param userName
     * @param roleName
     * @return void
     */
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO fx_user_role VALUES((SELECT USER_ID from fx_user where USER_NAME=?1),(SELECT ROLE_ID FROM fx_role WHERE ROLE_NAME=?2));")
    void save(String userName,String roleName);
}
