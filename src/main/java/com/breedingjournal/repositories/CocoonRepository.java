package com.breedingjournal.repositories;

import com.breedingjournal.domain.Cocoon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CocoonRepository extends CrudRepository <Cocoon, Long>{
    List<Cocoon> findById (Long id);
    List<Cocoon> findByCopulationId (Long id);

}