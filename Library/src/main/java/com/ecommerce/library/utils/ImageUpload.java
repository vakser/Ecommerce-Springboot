package com.ecommerce.library.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUpload {
    private final String UPLOAD_FOLDER = "C:\\Users\\vakal\\Desktop\\Ecommerce Youtube Tutorial\\Ecommerce-Springboot\\Admin\\src\\main\\resources\\static\\img\\image-product";
    public boolean uploadImage(MultipartFile imageProduct) {
        boolean isUploaded = false;
        try {
            Files.copy(imageProduct.getInputStream(),
                    Paths.get(UPLOAD_FOLDER + File.separator, imageProduct.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            isUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }

    public boolean checkExisting(MultipartFile imageProduct) {
        boolean isExisting = false;
        try {
            File file = new File(UPLOAD_FOLDER + "\\" + imageProduct.getOriginalFilename());
            isExisting = file.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExisting;
    }
}
