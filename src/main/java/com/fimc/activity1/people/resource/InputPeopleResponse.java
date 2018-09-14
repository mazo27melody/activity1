package com.fimc.activity1.people.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InputPeopleResponse implements Serializable {
	private String firstName;
	private String lastName;
	private String birthDate;

}
