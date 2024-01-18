package com.ujjaval.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse;
import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class PlanMaster {
	
@Id
@Column(name="PLAN_ID")
@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer planId;

	@Column(name="PLAN_NAME")
private String planName;

	@Column(name="PLAN_START_DATE")
private String planStartDate;

	@Column(name="PLAN_END_DATE")
private String planEndDate;

	@Column(name="PLAN_CATAGORY_ID")
private Integer planCatagoryId;

	@Column(name="ACTIVE_SW")
private String activeSw;

@CreationTimestamp
@Column(name="CREATE_DATE" , updatable =false )
private LocalDate createDate;

@UpdateTimestamp
@Column(name="UPDATE_DATE", insertable = false)
private LocalDate updateDate;

@Column(name="CREATED_BY")
private String createdBy;

@Column(name="updated_BY")
private String updatedBy;
}
