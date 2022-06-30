package br.com.lucahsouza.productapi.modules.product.dto;

import br.com.lucahsouza.productapi.modules.category.dto.CategoryResponse;
import br.com.lucahsouza.productapi.modules.category.model.Category;
import br.com.lucahsouza.productapi.modules.product.model.Product;
import br.com.lucahsouza.productapi.modules.supplier.dto.SupplierResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Integer id;
    private String name;
    private Integer quantityAvailable;
    private SupplierResponse supplier;
    private CategoryResponse category;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static ProductResponse of(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .quantityAvailable(product.getQuantityAvailable())
                .supplier(SupplierResponse.of(product.getSupplier()))
                .category(CategoryResponse.of(product.getCategory()))
                .createdAt(product.getCreatedAt())
                .build();
    }
}
