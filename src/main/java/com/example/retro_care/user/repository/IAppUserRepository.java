package com.example.retro_care.user.repository;

import com.example.retro_care.user.model.AppUser;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface IAppUserRepository extends JpaAttributeConverter<AppUser,Long> {
}
