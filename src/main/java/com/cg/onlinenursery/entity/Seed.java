package com.cg.onlinenursery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="Seed")
public class Seed implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="seedId")
	@GeneratedValue
	private Integer seedId;
	@Column(name="commonName")
	private String commonName;
	@Column(name="bloomTime")
	private String bloomTime;
	@Column(name="watering")
	private String watering;
	@Column(name="difficultyLevel")
	private String difficultyLevel;
	@Column(name="temparature")
	private String temparature;
	@Column(name="typeOfSeeds")
	private String typeOfSeeds;
	@Column(name="seedDescription")
	private String seedDescription ;
	@Column(name="seedStock")
	private Integer seedStock;
	@Column(name="seedPerPacket")
	private Integer seedPerPacket;
	
	
	@JsonProperty(access=Access.READ_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plantersid")
	private Planters planter;

	
     public Seed() {
	// TODO Auto-generated constructor stub
}

	public Seed(Integer seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
			String temparature, String typeOfSeeds, String seedsDescription, Integer seedsStock, Integer seedsPerPacket,Planters planters) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedDescription = seedsDescription;
		this.seedStock = seedStock;
		this.seedPerPacket = seedPerPacket;
		this.planter = planter;
	}

	public Integer getSeedId() {
		return seedId;
	}

	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemparature() {
		return temparature;
	}

	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}

	public String getSeedDescription() {
		return seedDescription;
	}

	public void setSeedDescription(String seedDescription) {
		this.seedDescription = seedDescription;
	}

	public Integer getSeedsStock() {
		return seedStock;
	}

	public void setSeedStock(Integer seedStock) {
		this.seedStock = seedStock;
	}

	public Integer getSeedPerPacket() {
		return seedPerPacket;
	}

	public void setSeedPerPacket(Integer seedPerPacket) {
		this.seedPerPacket = seedPerPacket;
	}
	public Planters getPlanters() {
		return planter;
	}

	public void setPlanters(Planters planters) {
		this.planter = planter;
	}
}