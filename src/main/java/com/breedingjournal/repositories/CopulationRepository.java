package com.breedingjournal.repositories;

import com.breedingjournal.domain.Copulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CopulationRepository extends JpaRepository<Copulation, Long> {
    List<Copulation> findById (Long id);







}
