package com.cg.onlinenursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinenursery.entity.Seed;
import com.cg.onlinenursery.repository.SeedRepository;

@Service
public class SeedServiceImpl {
	@Autowired
	private SeedRepository seedRepository;

	public List<Seed> viewSeed(String commonName) {
		List<Seed> seedList = seedRepository.findAll();
		return seedList;
	}

	public List<Seed> viewAllSeeds() {
		List<Seed> seedList = seedRepository.findAll();
		return seedList;
	}

	public List<Seed> viewSeed() {
		List<Seed> seedList = seedRepository.findAll();
		return seedList;
	}

	public List<Seed> viewAllSeeds(String typeOfSeed) {
		List<Seed> seedList = seedRepository.findAll();
		return seedList;

	}

	public Seed addSeed(Seed seed) {
		Seed seedexist = viewSeed(seed.getSeedId());
		if (seedexist == null) {
			seed = seedRepository.save(seed);
		}
		return seed;
	}

	public Seed updateSeed(Seed seed) {
		Seed seedexist = viewSeed(seed.getSeedId());
		if (seedexist != null) {
			seed = seedRepository.save(seed);
		}
		return seed;
	}

	public Seed deleteSeed(int seedId) {
		Seed seed = viewSeed(seedId);
		if (seed != null)
			seedRepository.deleteById(seedId);
		return seed;
	}

	public Seed viewSeed(int seedId) {
		Optional<Seed> optional = seedRepository.findById(seedId);
		Seed seed = null;
		if (optional.isPresent()) {
			seed = optional.get();
		}
		return seed;

	}
}
//package com.cg.onlinenursery.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.onlinenursery.entity.Seed;
//import com.cg.onlinenursery.repository.SeedRepository;
//
//@Service
//public class SeedServiceImpl {
//	@Autowired
//	private SeedRepository seedRepository;
//
//	public List<Seed> viewSeed(String commonName) {
//		List<Seed> seedList = seedRepository.findAll();
//		return seedList;
//	}
//
//	public List<Seed> viewAllSeeds() {
//		List<Seed> seedList = seedRepository.findAll();
//		return seedList;
//	}
//
//	public List<Seed> viewSeed() {
//		List<Seed> seedList = seedRepository.findAll();
//		return seedList;
//	}
//
//	public List<Seed> viewAllSeeds(String typeOfSeed) {
//		List<Seed> seedList = seedRepository.findAll();
//		return seedList;
//
//	}
//
//	public Seed addSeed(Seed seed) {
//		Seed seedexist = viewSeed(seed.getSeedId());
//		if (seedexist == null) {
//			seed = seedRepository.save(seed);
//		}
//		return seed;
//	}
//
//	public Seed updateSeed(Seed seed) {
//		Seed seedexist = viewSeed(seed.getSeedId());
//		if (seedexist != null) {
//			seed = seedRepository.save(seed);
//		}
//		return seed;
//	}
//
//	public Seed deleteSeed(int seedId) {
//		Seed seed = viewSeed(seedId);
//		if (seed != null)
//			seedRepository.deleteById(seedId);
//		return seed;
//	}
//
//	public Seed viewSeed(int seedId) {
//		Optional<Seed> optional = seedRepository.findById(seedId);
//		Seed seed = null;
//		if (optional.isPresent()) {
//			seed = optional.get();
//		}
//		return seed;
//
//	}
//}
////package com.cg.onlinenursery.service;
////
////import java.util.List;
////import java.util.Optional;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import com.cg.onlinenursery.entity.Planters;
////import com.cg.onlinenursery.entity.Seed;
////import com.cg.onlinenursery.repository.SeedRepository;
////
////@Service
////public class SeedServiceImpl {
////	@Autowired
////	private SeedRepository seedRepository;
////
////	public List<Seed> viewSeed(String commonName) {
////		List<Seed> seedList = seedRepository.findAll();
////		return seedList;
////}
////	public List<Seed> viewAllSeeds(){
////		List<Seed> seedList = seedRepository.findAll();
////		return seedList;
////}
////	public List<Seed> viewSeed() {
////		List<Seed> seedList = seedRepository.findAll();
////		return seedList;
////	}
////	
////	List<Seed> viewAllSeeds(String typeOfSeed){
////	List<Seed> seedList = seedRepository.findAll();
////	return seedList;
////
////	}
////	public Seed addSeed(Seed seed) {
////		Seed seedexist = viewSeed(seed.getSeedId());
////		if (seedexist == null) {
////			seed =seedRepository.save(seed);
////		}
////		return seed;
////}
////	public Seed updateSeed(Seed seed) {
////		Seed seedexist = viewSeed(seed.getSeedId());
////		if (seedexist != null) {
////			seed = seedRepository.save(seed);
////		}
////		return seed;
////}
////	public Seed deleteSeed(int seedId) {
////		Seed seed = viewSeed(seedId);
////		if (seed != null)
////			seedRepository.deleteById(seedId);
////		return seed;
////}
////	public Seed viewSeed(int seedId) {
////		Seed seed = viewSeed(seedId);
////		if (seed != null)
////			seedRepository.findById(seedId);
////		return seed;
////
////}
//		}