package com.mk.Pojos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private FavFoods favfoods;
	private List<String> jobs;
	private List<Marks> marks;

}
