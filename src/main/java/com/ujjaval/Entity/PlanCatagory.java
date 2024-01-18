
package com.ujjaval.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCatagory {


	
	@Id
	@Column(name ="CATAGORY_ID")
	@GeneratedValue
private Integer planCatagoryId;
	
	@Column(name= "CATAGORY_NAME")
	private String catagoryName;
	
	@Column(name="ACTIVE_SW")
	private String Sw;
	
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
