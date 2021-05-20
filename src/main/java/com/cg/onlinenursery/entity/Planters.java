package com.cg.onlinenursery.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "Planters")

public class Planters implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "planterId")
	//@GeneratedValue
	private Integer planterId;
	@Column(name = "planterheight")
	private float planterheight;
	@Column(name = "planterCapacity")
	private int planterCapacity;
	@Column(name = "planterdrinageHoles")
	private int drinageHoles;
	@Column(name = "planterColour")
	private String planterColor;
	@Column(name = "planterShape")
	private String planterShape;
	@Column(name = "planterStock")
	private int planterStock;
	@Column(name = "planterCost")
	private int planterCost;
	
	
	@JsonProperty(access=Access.READ_ONLY)
	@OneToMany(fetch = FetchType.LAZY,mappedBy="planter",targetEntity=Plants.class,orphanRemoval=true)
	@JsonIgnore
	private List<Plants> plants;
	
	@JsonProperty(access=Access.READ_ONLY)
	@OneToMany(fetch = FetchType.LAZY,mappedBy="planter",targetEntity=Seed.class,orphanRemoval=true)
    @JsonIgnore
	private List<Seed> seeds;

	public Planters(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, String planterColor,
			String planterShape, int planterStock, int planterCost, List<Plants> plants, List<Seed> seeds) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
		this.seeds = seeds;
	}
	
	public Planters() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public float getPlanterheight() {
		return planterheight;
	}

	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}

	public int getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public int getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public int getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}

	public int getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}

	public List<Plants> getPlants() {
		return plants;
	}

	public void setPlants(List<Plants> plants) {
		this.plants = plants;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}
}




//package com.cg.onlinenursery.entity;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;
//
//
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@Entity
//@Table(name = "Planters")
//
//public class Planters implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name = "planterId")
//	//@GeneratedValue
//	private Integer planterId;
//	@Column(name = "planterheight")
//	private float planterheight;
//	@Column(name = "planterCapacity")
//	private int planterCapacity;
//	@Column(name = "planterdrinageHoles")
//	private int drinageHoles;
//	@Column(name = "planterColour")
//	private String planterColor;
//	@Column(name = "planterShape")
//	private String planterShape;
//	@Column(name = "planterStock")
//	private int planterStock;
//	@Column(name = "planterCost")
//	private int planterCost;
//	
//	
//	@JsonProperty(access=Access.READ_ONLY)
//	@OneToMany(fetch = FetchType.LAZY,mappedBy="planter",targetEntity=Plants.class,orphanRemoval=true)
//	@JsonIgnore
//	private List<Plants> plants;
//	
//	@JsonProperty(access=Access.READ_ONLY)
//	@OneToMany(fetch = FetchType.LAZY,mappedBy="planters",targetEntity=Seed.class,orphanRemoval=true)
//    @JsonIgnore
//	private List<Seed> seeds;
//
//	@JsonProperty(access=Access.READ_ONLY)
//	@ManyToOne(fetch = FetchType.LAZY)
//	//@JoinColumn(name = "customerId")
//	private Customer customers;
//	
//
//	
//	public Planters(Customer customers) {
//		super();
//		this.customers = customers;
//	}
//
//	/**
//	 * @return the customers
//	 */
//	public Customer getCustomers() {
//		return customers;
//	}
//
//	/**
//	 * @param customers the customers to set
//	 */
//	public void setCustomers(Customer customers) {
//		this.customers = customers;
//	}
//
//	@JsonProperty(access=Access.READ_ONLY)
//	@ManyToOne(fetch = FetchType.LAZY)
//	//@JoinColumn(name = "plantersid")
//	private Order order;
//	
//
//	/**
//	 * @return the order
//	 */
//	public Order getOrder() {
//		return order;
//	}
//
//	/**
//	 * @param order the order to set
//	 */
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Planters(Order order) {
//		super();
//		this.order = order;
//	}
//
//	public Planters(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, String planterColor,
//			String planterShape, int planterStock, int planterCost, List<Plants> plants, List<Seed> seeds) {
//		super();
//		this.planterId = planterId;
//		this.planterheight = planterheight;
//		this.planterCapacity = planterCapacity;
//		this.drinageHoles = drinageHoles;
//		this.planterColor = planterColor;
//		this.planterShape = planterShape;
//		this.planterStock = planterStock;
//		this.planterCost = planterCost;
//		this.plants = plants;
//		this.seeds = seeds;
//	}
//	
//	public Planters() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Integer getPlanterId() {
//		return planterId;
//	}
//
//	public void setPlanterId(Integer planterId) {
//		this.planterId = planterId;
//	}
//
//	public float getPlanterheight() {
//		return planterheight;
//	}
//
//	public void setPlanterheight(float planterheight) {
//		this.planterheight = planterheight;
//	}
//
//	public int getPlanterCapacity() {
//		return planterCapacity;
//	}
//
//	public void setPlanterCapacity(int planterCapacity) {
//		this.planterCapacity = planterCapacity;
//	}
//
//	public int getDrinageHoles() {
//		return drinageHoles;
//	}
//
//	public void setDrinageHoles(int drinageHoles) {
//		this.drinageHoles = drinageHoles;
//	}
//
//	public String getPlanterColor() {
//		return planterColor;
//	}
//
//	public void setPlanterColor(String planterColor) {
//		this.planterColor = planterColor;
//	}
//
//	public String getPlanterShape() {
//		return planterShape;
//	}
//
//	public void setPlanterShape(String planterShape) {
//		this.planterShape = planterShape;
//	}
//
//	public int getPlanterStock() {
//		return planterStock;
//	}
//
//	public void setPlanterStock(int planterStock) {
//		this.planterStock = planterStock;
//	}
//
//	public int getPlanterCost() {
//		return planterCost;
//	}
//
//	public void setPlanterCost(int planterCost) {
//		this.planterCost = planterCost;
//	}
//
//	public List<Plants> getPlants() {
//		return plants;
//	}
//
//	public void setPlants(List<Plants> plants) {
//		this.plants = plants;
//	}
//
//	public List<Seed> getSeeds() {
//		return seeds;
//	}
//
//	public void setSeeds(List<Seed> seeds) {
//		this.seeds = seeds;
//	}
//}