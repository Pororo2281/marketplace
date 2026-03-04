package product_service.demo.Request;

import product_service.demo.Enum.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

public class UpdateProductRequest {

    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal oldPrice;
    private Integer stockQuantity;
    private Long categoryId;
    private ProductStatus status;

    private List<UpdateAttributeRequest> attributes;

    public UpdateProductRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getOldPrice() { return oldPrice; }
    public void setOldPrice(BigDecimal oldPrice) { this.oldPrice = oldPrice; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }

    public List<UpdateAttributeRequest> getAttributes() { return attributes; }
    public void setAttributes(List<UpdateAttributeRequest> attributes) { this.attributes = attributes; }
}