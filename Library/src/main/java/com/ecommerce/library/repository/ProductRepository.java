package com.ecommerce.library.repository;

import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p")
    Page<Product> pageProduct(Pageable pageable);

    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    Page<Product> searchProducts(String keyword, Pageable pageable);

    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    List<Product> searchProductsList(String keyword);

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false")
    List<Product> getAllProducts();

    @Query(value = "select * from products p where p.is_activated = true and p.is_deleted = false order by rand() asc limit 4", nativeQuery = true)
    List<Product> listViewProducts();

    @Query(value = "select p from Product p inner join Category c on c.id = ?1 and p.category.id = ?1 where p.is_activated = true and p.is_deleted = false")
    List<Product> getRelatedProducts(long categoryId);

    @Query(value = "select p from Product p inner join Category c on c.id = p.category.id where c.id = ?1 and c.is_activated = true and c.is_deleted = false")
    List<Product> getProductsInCategory(long categoryId);

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false order by p.costPrice desc")
    List<Product> filterHighPrice();

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false order by p.costPrice")
    List<Product> filterLowPrice();
}
