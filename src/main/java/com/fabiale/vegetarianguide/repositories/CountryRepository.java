package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import com.fabiale.vegetarianguide.model.Country;

public interface CountryRepository {

	public List<Country> getAll();

	public Integer create(Country country);
    
    public Country findById(Integer id);
    
    public Country findByName(String name);
}
