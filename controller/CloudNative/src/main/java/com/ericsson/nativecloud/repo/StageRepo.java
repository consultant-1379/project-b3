package com.ericsson.nativecloud.repo;

import com.ericsson.nativecloud.model.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepo extends CrudRepository<Stage, Integer> {

}
