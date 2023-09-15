package com.example.retro_care.user.repository;

import com.example.retro_care.user.model.AppUser;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    @Query(value = "select * from retro_care.app_user where user_name = :name")
    AppUser findAppUserByName(@Param("name") String userName);
}
