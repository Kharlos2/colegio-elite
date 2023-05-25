package com.example.colegioelite.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Profesor extends JpaRepository<Profesor,Integer> {
}
