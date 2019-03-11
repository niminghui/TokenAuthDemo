package com.shiep.jwtauth.repository;

import com.shiep.jwtauth.entity.FXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 14:59
 * @description: FXUser的dao层
 */

@Repository
public interface FXUserRepository extends JpaRepository<FXUser,Integer> {
    /**
     * description: 通过UserName查找User
     *
     * @param userName
     * @return com.shiep.jwtauth.entity.FXUser
     */
    FXUser findByName(String userName);

    /**
     * description: 通过UserName查找该用户的角色列表
     *
     * @param userName
     * @return java.lang.String
     */
    @Query(nativeQuery = true,value ="SELECT ROLE_NAME from fx_role WHERE ROLE_ID in (select ROLE_ID from fx_user_role where USER_ID = (select USER_ID from fx_user where USER_NAME= ?1));")
    List<String> getRolesByUserName(String userName);


}
