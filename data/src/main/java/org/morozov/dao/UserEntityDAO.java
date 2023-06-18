package org.morozov.dao;

import org.morozov.enitity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityDAO extends JpaRepository<UserEntity, Long> {
}
