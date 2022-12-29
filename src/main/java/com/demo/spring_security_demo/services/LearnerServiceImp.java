package com.demo.spring_security_demo.services;

import com.demo.spring_security_demo.models.Learner;
import com.demo.spring_security_demo.repositories.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerServiceImp implements LearnerService{
    @Autowired
    private LearnerRepo learnerRepo;

    public LearnerServiceImp(LearnerRepo learnerRepo) {
        this.learnerRepo = learnerRepo;
    }

    @Override
    public void saveLearner(Learner learner) {

    }

    @Override
    public void updateLearner(Learner learner) {

    }

    @Override
    public void deleteLearner(Learner learner) {

    }

    @Override
    public Learner getLearnerById(int id) {
        return null;
    }

    @Override
    public Iterable<Learner> getAllLearner() {
        return null;
    }

    public Learner findByEmail(String email) {
        System.out.println("this is findByEmailOrUsername");
        Learner learner =  learnerRepo.findByEmail(email);
        System.out.println("hada learner "+learner);
        return learner;
    }
}
