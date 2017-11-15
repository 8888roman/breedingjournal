package com.breedingjournal.repositories;

import com.breedingjournal.domain.Copulation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopulationRepository extends CrudRepository <Copulation, Long>{
    List<Copulation> findById (Long id);


}
