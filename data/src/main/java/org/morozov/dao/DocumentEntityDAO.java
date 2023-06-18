package org.morozov.dao;

import org.morozov.enitity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentEntityDAO extends JpaRepository<DocumentEntity, Long> {
}
