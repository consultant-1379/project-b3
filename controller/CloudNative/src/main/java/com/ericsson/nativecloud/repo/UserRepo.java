package com.ericsson.nativecloud.repo;

import com.ericsson.nativecloud.model.SurveyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<SurveyUser, Integer> {
}
