package com.cg.onlinenursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinenursery.entity.Plants;
import org.springframework.stereotype.Repository;
@Repository
public interface PlantsRepository extends JpaRepository<Plants,Integer> {

}
