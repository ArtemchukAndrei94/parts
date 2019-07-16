package com.parts.Repos;

import com.parts.domain.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepo extends CrudRepository<Part, Long> {
}
