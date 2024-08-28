package com.ericsson.nativecloud.repo;

import com.ericsson.nativecloud.model.LeadingQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<LeadingQuestion, Integer> {

}
