package com.demo.spring_security_demo.repositories;

import com.demo.spring_security_demo.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepo extends JpaRepository<Learner,Integer> {

    @Query("SELECT l FROM Learner l WHERE l.email=?1")
    Learner findByEmail(String email);

}

