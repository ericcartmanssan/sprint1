package com.cg.onlinenursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinenursery.entity.Seed;
import org.springframework.stereotype.Repository;
@Repository
public interface SeedRepository extends JpaRepository<Seed,Integer> {

}
