package com.fabiale.vegetarianguide.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dropbox.client2.exception.DropboxException;
import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;

public interface ImageService {
	
	public List<Image> getAll();

	public Integer create(Image image);
	
	public Image getById(Integer id) throws SQLException;
	
	public List<Image> getByRestaurant(Restaurant restaurant) throws DropboxException;
	
	public List<Image> getByRestaurant(Restaurant restaurant, int qtd) throws DropboxException;
	
	public List<Image> getLastUptades(int quantity);
	
	public void upload(Image image, byte[] bytes) throws DropboxException, IOException;
}
