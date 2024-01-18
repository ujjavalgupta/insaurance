package com.ujjaval.service;

import java.util.List;
import java.util.Map;

import com.ujjaval.Entity.PlanMaster;

public interface PlanService {
	
	public Map<Integer, String> getPlanCatagory();
	
	public Boolean savePlan(PlanMaster planMaster);
	
	public List<PlanMaster> getAllPlanMasters();
	
	public PlanMaster getPlanById(Integer planMasterId);
	
	public Boolean updatePlan(PlanMaster planMaster);
	
	public Boolean deletePlanMasterbyId(Integer PlanMasterId);
	
	public Boolean planStatus(Integer planMasterId, String status);
	

}
