package com.ecommerce.library.service;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    Product save(MultipartFile imageProduct, ProductDto productDto);

    Product update(MultipartFile imageProduct, ProductDto productDto);

    void disableById(long id);

    void enableById(long id);

    ProductDto getById(long id);

    Page<ProductDto> pageProducts(int pageNo);

    Page<ProductDto> searchProducts(int pageNo, String keyword);

    List<Product> getAllProducts();

    List<Product> listViewProducts();

    Product getProductById(long id);

    List<Product> getRelatedProducts(long categoryId);

    List<Product> getProductsInCategory(long categoryId);

    List<Product> filterHighPrice();

    List<Product> filterLowPrice();
}
