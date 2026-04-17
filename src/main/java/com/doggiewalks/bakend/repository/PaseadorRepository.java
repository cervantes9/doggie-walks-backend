package com.doggiewalks.bakend.repository;

import com.doggiewalks.bakend.Paseador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadorRepository extends JpaRepository<Paseador, Integer> {
}