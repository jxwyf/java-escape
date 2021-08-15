package com.lhalj.spring.escape.transaction_lost;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 */
public interface IdAndNameDao extends JpaRepository<IdAndName,Long> {
}
