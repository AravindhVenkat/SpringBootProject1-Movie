package com.sprboot.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="movie")
@ApiModel("Movie Entity")
public class Movie
{
	@Id
	@Min(value=1,message="id should be greater than one")	
	@ApiModelProperty("Only unique values are allowed")
	private int mid;
	@NotEmpty
	@ApiModelProperty("name shouldn't be empty")
	private String mname;
	@NotEmpty
	@ApiModelProperty("genre shouldnt be empty")
	private String mgenre;
	
	private int mrating;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgenre() {
		return mgenre;
	}
	public void setMgenre(String mgenre) {
		this.mgenre = mgenre;
	}
	public int getMrating() {
		return mrating;
	}
	public void setMrating(int mrating) {
		this.mrating = mrating;
	}
	public Movie(int mid, String mname, String mgenre, int mrating) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mgenre = mgenre;
		this.mrating = mrating;
	}
	public Movie() {
		
	}
}

