package com.ujjaval.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujjaval.Entity.PlanCatagory;
import com.ujjaval.Entity.PlanMaster;
import com.ujjaval.repo.PlanCatagoryRepo;
import com.ujjaval.repo.PlanMasterRepo;

@Service
public class PlanImpl implements PlanService {
	@Autowired
	private PlanCatagoryRepo planCatagoryRepo;
	
	@Autowired
	private PlanMasterRepo planMasterRepo;

	@Override
	public Map<Integer, String> getPlanCatagory() {
		List<PlanCatagory> findAll = planCatagoryRepo.findAll();
		Map<Integer, String> getList=new HashMap<>();
		findAll.forEach(catagory ->{
			getList.put(catagory.getPlanCatagoryId(), catagory.getCatagoryName());
		});
		return getList;
	}
	

	@Override
	public Boolean savePlan(PlanMaster planMaster){
		PlanMaster save = planMasterRepo.save(planMaster);
		return save.getPlanCatagoryId()!=null;
	}

	@Override
	public List<PlanMaster> getAllPlanMasters() {
		List<PlanMaster> plan = planMasterRepo.findAll();
		return plan;
	}

	@Override
	public PlanMaster getPlanById(Integer planId) {
		Optional<PlanMaster> findById = planMasterRepo.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
			return null ;
		
		
	}

	@Override
	public Boolean updatePlan(PlanMaster planMaster) {
		PlanMaster update = planMasterRepo.save(planMaster);
		return update.getPlanCatagoryId()!=null;
	}

	@Override
	public Boolean deletePlanMasterbyId(Integer PlanMasterId) {
		Boolean status =false;
	 try {
		 planMasterRepo.deleteById(PlanMasterId);
		 status =true;
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
		return status;
	}

	@Override
	public Boolean planStatus(Integer planMasterId, String status) {
		Optional<PlanMaster> findById = planMasterRepo.findById(planMasterId);
		if(findById.isPresent()) {
			PlanMaster planMaster=findById.get();
			planMaster.setActiveSw(status);
			planMasterRepo.save(planMaster);
			return true;
		}
		return false;
	}

}
