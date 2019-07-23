package com.parts.Repos;

import com.parts.domain.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface PartRepo extends CrudRepository<Part, Long> {

    Part findById(Integer id);

    Page<Part> findByName(String name, Pageable pageable);

    Page<Part> findAll(Pageable pageable);

    Page<Part> findByNeed(Integer need, Pageable pageable);

}
