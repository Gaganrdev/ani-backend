package com.ani.backend.repositories;

import com.ani.backend.dao.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface PropertyRepository extends JpaRepository<Property, Long> {


}

