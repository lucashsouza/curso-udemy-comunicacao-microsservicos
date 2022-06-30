package br.com.lucahsouza.productapi.modules.product.repository;

import br.com.lucahsouza.productapi.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameIgnoreCaseContaining(String name);
    List<Product> findBySupplierId(Integer id);
    List<Product> findByCategoryId(Integer id);
    Boolean existsBySupplierId(Integer supplierId);
    Boolean existsByCategoryId(Integer categoryId);

}
