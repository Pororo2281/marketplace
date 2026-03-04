package product_service.demo.Request;

public class UpdateStockRequest {

    private Integer stockQuantity;

    public UpdateStockRequest() {
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
