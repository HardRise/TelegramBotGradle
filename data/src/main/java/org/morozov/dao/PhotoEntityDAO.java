package org.morozov.dao;

import org.morozov.enitity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoEntityDAO extends JpaRepository<PhotoEntity, Long> {
}
