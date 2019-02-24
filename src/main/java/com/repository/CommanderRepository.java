package com.repository;

import com.entity.Commander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommanderRepository extends JpaRepository<Commander,Long> {
}
