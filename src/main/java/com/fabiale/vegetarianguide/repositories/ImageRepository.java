package com.fabiale.vegetarianguide.repositories;

import java.sql.SQLException;
import java.util.List;

import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;

public interface ImageRepository {
	
	public List<Image> getAll();

	public Integer create(Image image);
    
    public Image getById(Integer id) throws SQLException;
    
	public List<Image> getByRestaurant(Restaurant restaurant);
    
	public List<Image> getByRestaurant(Restaurant restaurant, int qtd);
    
    public List<Image> getLastUptades(int quantity);

}
