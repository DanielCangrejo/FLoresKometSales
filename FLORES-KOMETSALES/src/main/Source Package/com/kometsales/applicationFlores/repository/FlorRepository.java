package com.kometsales.applicationFlores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kometsales.applicationFlores.model.Flor;

@Repository
public interface FlorRepository extends JpaRepository<Flor,Long> {
	
	List<Flor> findByNombreContainingIgnoreCase(String nombre);
}