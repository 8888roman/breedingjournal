package com.breedingjournal.repositories;

import com.breedingjournal.domain.Cocoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CocoonRepository extends JpaRepository<Cocoon, Long> {
    List<Cocoon> findById (Long id);
    List<Cocoon> findByCopulationId (Long id);



   void removeById (Long id);


}
