package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.SurveyUser;
import com.ericsson.nativecloud.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {


        @Autowired
        private UserRepo userRepo;

        public Iterable<SurveyUser> listAllUser() {
            return userRepo.findAll();
        }

        public void saveUser(SurveyUser user) {
            userRepo.save(user);
        }

        public SurveyUser getUser(Integer id) {
            Optional<SurveyUser> s = this.userRepo.findById(id);
            if(s.isPresent()){
                return s.get();
            }
            return null;
        }

}

