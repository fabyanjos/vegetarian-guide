package com.fabiale.vegetarianguide.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class ImageExtensionValidator implements
		ConstraintValidator<ImageExtension, MultipartFile> {

	private String[] extension;

	@Override
	public void initialize(ImageExtension imageExtension) {
		extension = imageExtension.extension();
	}

	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext validatorContext) {
		try {
			String[] split = file.getOriginalFilename().split("\\.");
			if(split != null) {
				for(String ext : extension) {
					if(split[split.length-1].equalsIgnoreCase(ext))
						return true;
				}
			}
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
}
