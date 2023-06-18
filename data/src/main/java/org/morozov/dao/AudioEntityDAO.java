package org.morozov.dao;

import org.morozov.enitity.AudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioEntityDAO extends JpaRepository<AudioEntity, Long> {
}
