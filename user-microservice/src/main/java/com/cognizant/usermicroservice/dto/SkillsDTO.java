package com.cognizant.usermicroservice.dto;

import java.math.BigDecimal;

public class SkillsDTO {
	private int id;
	private String name;
	private BigDecimal duration;
	private String tableOfContents;
	private String prerequites;

	public SkillsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillsDTO(int id, String name, BigDecimal duration, String tableOfContents, String prerequites) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.tableOfContents = tableOfContents;
		this.prerequites = prerequites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getPrerequites() {
		return prerequites;
	}

	public void setPrerequites(String prerequites) {
		this.prerequites = prerequites;
	}

	@Override
	public String toString() {
		return "SkillsDTO [id=" + id + ", name=" + name + ", duration=" + duration + ", tableOfContents="
				+ tableOfContents + ", prerequites=" + prerequites + "]";
	}

}
