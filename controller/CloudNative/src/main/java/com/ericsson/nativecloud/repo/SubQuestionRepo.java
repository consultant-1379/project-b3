package com.ericsson.nativecloud.repo;

import com.ericsson.nativecloud.model.SubQuestions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubQuestionRepo extends CrudRepository<SubQuestions, Integer> {
}
