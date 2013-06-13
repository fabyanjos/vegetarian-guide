package com.fabiale.vegetarianguide.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.DropboxAPI.DropboxLink;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.DropboxAPI.ThumbFormat;
import com.dropbox.client2.DropboxAPI.ThumbSize;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.WebAuthSession;
import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.repositories.ImageRepository;
import com.fabiale.vegetarianguide.util.ImageUtil;

@Service
public class ImageService {
	
    private static final String FOLDER_NAME = "/Public/veggie-out/";
	
	@Autowired
	private ImageRepository repository;
	@Autowired
	private ImageUtil imageUtil;
	@Autowired
	private DropboxAPI<WebAuthSession> dbApi;

	public List<Image> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Image image) {
		return this.repository.create(image);
	}
	
	public Image getById(Integer id) throws SQLException {
		return this.repository.getById(id);
	}
	
	public List<Image> getByRestaurant(Restaurant restaurant) throws DropboxException {
		List<Image> images = this.repository.getByRestaurant(restaurant);
		for (Image image : images) {
			DropboxLink media = dbApi.media(image.getFilePath(), false);
			image.setFilePath(media.url);
		}
		return images;
	}
	
	public List<Image> getLastUptades(int quantity) {
		return this.repository.getLastUptades(quantity);
	}
	
	public void upload(Image image, byte[] bytes) throws DropboxException, IOException {
        // Resize Image
        BufferedImage resizeImage = imageUtil.resizeImage(new ByteArrayInputStream(bytes));
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        ImageIO.write(resizeImage,"jpg", bas);
        InputStream newIs = new ByteArrayInputStream(bas.toByteArray(), 0, bas.size());
        
        // Upload image
        byte[] byteArray = byteArray(newIs);
//        ChunkedUploader chunkedUploader = dbApi.getChunkedUploader(newIs, byteArray.length);
//        chunkedUploader.upload();
//        Entry newEntry = chunkedUploader.finish(FOLDER_NAME + image.getFilename(), null);
        
        Entry newEntry = dbApi.putFile(FOLDER_NAME + image.getFilename(), newIs, byteArray.length, null, null);
        
        DropboxFileInfo thumbnail = dbApi.getThumbnail(newEntry.path, new ByteArrayOutputStream(), ThumbSize.ICON_128x128, ThumbFormat.JPEG, null);
        System.out.println("thumbnail: " + (dbApi.media(thumbnail.getMetadata().path, false)).url);
        System.out.println("Path:" + newEntry.path);
		
//        dbApi.share(newEntry.path);
//        DropboxLink media = dbApi.media(newEntry.path, false);
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        System.out.println("expires: " + format.format(media.expires));
//        
//        System.out.println("Media: " + media.url);
        image.setFilePath(newEntry.path);
        this.create(image);
	}
	
	private byte[] byteArray(InputStream is) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();
		is.reset();
		return buffer.toByteArray();
	}
}
