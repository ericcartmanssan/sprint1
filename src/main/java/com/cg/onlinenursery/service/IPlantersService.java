package com.cg.onlinenursery.service;

import java.util.List;

import com.cg.onlinenursery.entity.Planters;

public interface IPlantersService {
	public List<Planters>getPlanters();

	//public Planters getPlanters(int plantersId);
	
	public Planters addPlanters(Planters planters);

	public Planters updatePlanters(Planters planters);

	public Planters deletePlanters(int plantersId);

	public Planters viewPlanters(int plantersId);

	public List<Planters>  viewPlanters(String plantersShape);

	public List<Planters> viewAllPlanters();

	public List<Planters> viewAllPlanters(double minCost, double maxCost);
}