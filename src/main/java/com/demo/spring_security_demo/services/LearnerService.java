package com.demo.spring_security_demo.services;

import com.demo.spring_security_demo.models.Learner;

public interface LearnerService {
    public void saveLearner(Learner learner);
    public void updateLearner(Learner learner);
    public void deleteLearner(Learner learner);
    public Learner getLearnerById(int id);
    public Iterable<Learner> getAllLearner();
}

