package com.fabiale.vegetarianguide.service;

import java.util.List;

import com.fabiale.vegetarianguide.model.Country;

public interface CountryService {

	public List<Country> getAll();

	public Integer create(Country country);

	public Country findByName(String name);
}
