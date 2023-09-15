package com.example.retro_care.user.repository;

import com.example.retro_care.user.model.AppUser;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUserName(String userName);
}
