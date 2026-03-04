package product_service.demo.dto.request;

import jakarta.validation.constraints.*;
import product_service.demo.Enum.ProductStatus;
import product_service.demo.Request.ProductAttributeRequest;

import java.math.BigDecimal;
import java.util.List;

public class CreateProductRequest {

    private String title;

    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private Long categoryId;

    // Атрибуты товара (цвет, размер и т.д.)
    private List<ProductAttributeRequest> attributes;

    // Конструкторы
    public CreateProductRequest() {}

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public List<ProductAttributeRequest> getAttributes() { return attributes; }
    public void setAttributes(List<ProductAttributeRequest> attributes) { this.attributes = attributes; }
}