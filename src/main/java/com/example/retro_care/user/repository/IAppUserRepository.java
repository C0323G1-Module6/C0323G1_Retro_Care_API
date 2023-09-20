package com.example.retro_care.user.repository;

import com.example.retro_care.user.model.AppUser;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    /**
     * method: findAppUserByName
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: AppUser
     */
    @Query(value = "select * from retro_care.app_user where user_name = :name", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String userName);

    /**
     * method: addNewAppUser
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: AppUser appUser
     * return: Integer
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO app_user (user_name, password,flag_online, flag_deleted)\n" +
            "VALUES (:#{#appUser.userName},:#{#appUser.password}, 0, 0)", nativeQuery = true)
    Integer addNewAppUser(AppUser appUser);
    /**
     * method: updateAppUserIsOnline
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: AppUser appUser
     * return: Integer
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 1 where id = :#{#appUser.id} ",nativeQuery = true)
    Integer updateAppUserIsOnline(AppUser appUser);
    /**
     * method: updateAppUserIsOffline
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: Integer
     */
    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 0 where user_name = :userName ",nativeQuery = true)
    Integer updateAppUserIsOffline(@Param("userName") String userName);

    /**
     * method: updateAppUserIsOffline
     * Creater: NhatNHH
     * Date: 18-09-2023
     * param: String userName
     * return: Long
     */
    @Query(value = " select au.id from retro_care.app_user au where au.user_name = :userName ",nativeQuery = true)
    Long findIdByUserName(@Param("userName") String userName);

    /**
     * method: updateAppUserIsOffline
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: Integer
     */
    @Query(value =  " select r.id from app_role r where r.name = :name " ,nativeQuery = true)
    Long findAppRoleIdByName(@Param("name")String name);

    /**
     * method: updateAppUserIsOffline
     * Creater: NhatNHH
     * Date: 15-09-2023
     * param: String userName
     * return: void
     */
    @Modifying
    @Transactional
    @Query(value = " call addRoleForAppUser(:appRoleId,:appUserId) ",nativeQuery = true)
    void insertRoleForCustomer(@Param("appRoleId") Long appRoleId,@Param("appUserId") Long appUserId);

}
