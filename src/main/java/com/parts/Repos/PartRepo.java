package com.parts.Repos;

import com.parts.domain.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface PartRepo extends PagingAndSortingRepository<Part, Long> {

    Part findById(Integer id);

    Page<Part> findByName(String name, Pageable pageable);

    Page<Part> findAll(Pageable pageable);

    List<Part> findAll();

    Page<Part> findByNeed(Integer need, Pageable pageable);




}
