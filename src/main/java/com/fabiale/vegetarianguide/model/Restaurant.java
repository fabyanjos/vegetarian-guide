package com.fabiale.vegetarianguide.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "restaurants")
@XmlRootElement
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 6594634391946827288L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String street;
	private Integer number;
	private String postalCode;
	private Type type;
	
	
}
