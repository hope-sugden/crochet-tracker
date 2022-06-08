package com.example.crochettracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrochetRepository extends JpaRepository<CrochetProject, Integer> {

    int deleteCrochetProjectByProjectId(int projectId);
}
