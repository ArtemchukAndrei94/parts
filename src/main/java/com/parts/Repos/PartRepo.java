package com.parts.Repos;

import com.parts.domain.Part;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepo extends CrudRepository<Part, Long> {

    List<Part> findByName(String name);
}
