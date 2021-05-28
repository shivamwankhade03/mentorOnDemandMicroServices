package com.cognizant.usermicroservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "name")
	String name;

	@NotNull
	@Column(name = "duration")
	BigDecimal duration;

	@Column(name = "table_of_contents")
	String tableOfContents;

	@Column(name = "prerequites")
	String prerequites;

	public Skills() {
		super();
	}

	public Skills(@NotNull int id, @NotNull String name, @NotNull BigDecimal duration, String tableOfContents,
			String prerequites) {
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
		return "Skills [id=" + id + ", name=" + name + ", duration=" + duration + ", tableOfContents=" + tableOfContents
				+ ", prerequites=" + prerequites + "]";
	}

}
