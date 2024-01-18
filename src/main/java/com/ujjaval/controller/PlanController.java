package com.ujjaval.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujjaval.Entity.PlanMaster;
import com.ujjaval.constant.AppConstant;
import com.ujjaval.props.AppProperties;
import com.ujjaval.service.PlanService;


@RestController
public class PlanController {

	private PlanService planService;
	
	
	private Map<String, String> messages;
	
	
	
	public PlanController(PlanService planService, AppProperties appProps) {
		
		this.planService = planService;
		this.messages = appProps.getMessages();
	}

	@GetMapping("/catagories")
	public ResponseEntity<Map<Integer, String>> getAllPlanCatagory(){
		Map<Integer, String> planCatagory = planService.getPlanCatagory();
		return new ResponseEntity<>(planCatagory, HttpStatus.OK);
	}
	
		@PostMapping("/plan")
		public ResponseEntity<String> savePlan(@RequestBody PlanMaster planMaster){
			String msg =AppConstant.CONSTANT_STR;
			boolean savePlan2 = planService.savePlan(planMaster);
			if (savePlan2) {
				msg=messages.get(AppConstant.PLAN_SUCC);
			}
			else {
				msg=messages.get(AppConstant.PLAN_FAIL);
			}
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
	
		@GetMapping("/plans")
	public ResponseEntity<List<PlanMaster>> plans(){
		List<PlanMaster> plans= planService.getAllPlanMasters();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}
		@GetMapping("/plans/{planID}")
		public ResponseEntity<PlanMaster> editPlan(@PathVariable Integer planId){
			PlanMaster plan = planService.getPlanById(planId);
			return new ResponseEntity<>(plan,HttpStatus.OK);
		}
		@PutMapping("/plan")
		public ResponseEntity<String> updatePlan(@RequestBody PlanMaster planMaster){
			Boolean updatePlan = planService.updatePlan(planMaster);
			String msg =AppConstant.CONSTANT_STR;
			if (updatePlan) {
				msg=messages.get(AppConstant.PLAN_UPDATE_SUCC);
			}
			else {
				msg=messages.get(AppConstant.PLAN_UPDATE_FAIL);
			}
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
		
		
		
		@DeleteMapping("/plan/{planMasterId}")
		public ResponseEntity<String> deletePlan(@PathVariable Integer planMasterId){
			Boolean deletePlanMasterbyId = planService.deletePlanMasterbyId(planMasterId);
			 String msg1=AppConstant.CONSTANT_STR;
			 if (deletePlanMasterbyId) {
				msg1=messages.get(AppConstant.PLAN_DEL_SUCC);
			}
			 else {
				msg1=messages.get(AppConstant.PLAN_DEL_FAIL);
			}
			return new ResponseEntity<>(msg1, HttpStatus.OK);
			 
		}
		
		@PutMapping("/status-change/{planMasterId}/{status}")
		public ResponseEntity<String> swichStatus(@PathVariable  Integer planMasterId, String status){
			String msg=AppConstant.CONSTANT_STR;
			Boolean planStatus = planService.planStatus(planMasterId, status);
			if (planStatus) {
				msg=messages.get(AppConstant.PLAN_STATUS_SUCC);
			}
			else {
				msg=messages.get(AppConstant.PLAN_STATUS_FAIL);
			}
			return new ResponseEntity<>(msg,HttpStatus.OK);
			
		}

}
