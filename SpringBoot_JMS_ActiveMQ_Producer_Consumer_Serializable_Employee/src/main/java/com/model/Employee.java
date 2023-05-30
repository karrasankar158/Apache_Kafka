package com.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -4627522268858374959L;
	
	private Integer id;
	private String code;

}
