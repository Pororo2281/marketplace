package product_service.demo.Request;

import java.math.BigDecimal;

public class UpdatePriceRequest {

    private BigDecimal price;
    private BigDecimal oldPrice;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }
}
