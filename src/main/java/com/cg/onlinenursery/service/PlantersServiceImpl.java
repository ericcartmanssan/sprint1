package com.cg.onlinenursery.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinenursery.entity.Planters;
import com.cg.onlinenursery.entity.Plants;
import com.cg.onlinenursery.repository.PlantersRepository;


@Service
public class PlantersServiceImpl implements IPlantersService {

	@Autowired
	private PlantersRepository plantersRepository;

	
	public List<Planters> getPlanters() {
		List<Planters> PlantersList = plantersRepository.findAll();
		return PlantersList;
	}

//	@Override
//	public Planters getPlanters(int plantersId) {
//		Optional<Planters> optional = plantersRepository.findById(plantersId);
//		return optional.get();
//	}

	// @Override
	public List<Plants> getPlants(int plantersId) {
		Optional<Planters> optional = plantersRepository.findById(plantersId);
		Planters planter = optional.get();
		List<Plants> plants = planter.getPlants();

		return plants;
	}

	@Override

	public Planters addPlanters(Planters planters) {
		Planters plantersexist = viewPlanters(planters.getPlanterId());
		if (plantersexist == null) {
			planters =plantersRepository.save(planters);
		}
		return planters;
	}

	public Planters updatePlanters(Planters planters) {
		Planters plantersexist = viewPlanters(planters.getPlanterId());
		if (plantersexist != null) {
			planters = plantersRepository.save(planters);
		}
		return planters;
	}

	public Planters deletePlanters(int plantersId) {
		Planters planters = viewPlanters(plantersId);
		if (planters != null)
			plantersRepository.deleteById(plantersId);
		return planters;
	}

	public Planters viewPlanters(int plantersId) {
		 	Optional<Planters> optional = plantersRepository.findById(plantersId);
		 	Planters planters=null;
		    if(optional.isPresent()) {
		    	planters=optional.get();
		    }
		return planters;

	}
	public List<Planters>  viewPlanters(String plantersShape) {
		List<Planters> planters= plantersRepository.planterShape(plantersShape);
		return planters;
	}



	public List<Planters> viewAllPlanters() {
		List<Planters> plantersList = plantersRepository.findAll();
		return plantersList;
}


	

	public List<Planters> viewAllPlanters(double minCost, double maxCost) {
	     List<Planters> plantersList = plantersRepository.findAll();
	     return plantersList;
	}
}