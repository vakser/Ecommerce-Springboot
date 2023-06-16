package com.ecommerce.customer.controller;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.getAllProducts();
        List<Product> listViewProducts = productService.listViewProducts();
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("products", products);
        model.addAttribute("viewProducts", listViewProducts);
        return "shop";
    }

    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") long id, Model model) {
        Product product = productService.getProductById(id);
        long categoryId = product.getCategory().getId();
        List<Product> products = productService.getRelatedProducts(categoryId);
        model.addAttribute("product", product);
        model.addAttribute("products", products);
        return "product-detail";
    }

    @GetMapping("/products-in-category/{id}")
    public String getProductsInCategory(@PathVariable("id") long categoryId, Model model) {
        Category category = categoryService.findById(categoryId);
        List<Product> products = productService.getProductsInCategory(categoryId);
        List<CategoryDto> categories = categoryService.getCategoryAndProduct();
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "products-in-category";
    }

    @GetMapping("/high-price")
    public String filterHighPrice(Model model) {
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.filterHighPrice();
        model.addAttribute("categories", categories);
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("products", products);
        return "filter-high-price";
    }

    @GetMapping("/low-price")
    public String filterLowPrice(Model model) {
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.filterLowPrice();
        model.addAttribute("categories", categories);
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("products", products);
        return "filter-low-price";
    }
}
