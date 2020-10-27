package com.riiidlabs.assessment.repository;

import com.riiidlabs.assessment.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {

}
