package com.fabiale.vegetarianguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.Country;
import com.fabiale.vegetarianguide.repositories.CountryRepository;
import com.fabiale.vegetarianguide.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository repository;

	public List<Country> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Country country) {
		return this.repository.create(country);
	}

	public Country findByName(String name) {
		return this.repository.findByName(name);
	}
}
