package com.mk.Pojos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class Marks {

	private int tamil;
	private int english;

}
