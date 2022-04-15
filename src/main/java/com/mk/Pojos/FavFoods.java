package com.mk.Pojos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class FavFoods {

	private String breakFast;
	private String lunch;
	private List<String> dinner;
	
	

}
