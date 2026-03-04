package product_service.demo.Mapper;

import product_service.demo.Entity.ProductEntity;
import product_service.demo.Response.ProductAttributeResponse;
import product_service.demo.Response.ProductImageResponse;
import product_service.demo.Response.ProductResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponse entityToProduct(ProductEntity entity){
        var productResponse = new ProductResponse();
        productResponse.setId(entity.getId());
        productResponse.setDescription(entity.getDescription());
        productResponse.setTitle(entity.getTitle());
        productResponse.setCreatedAt(entity.getCreatedAt());
        productResponse.setPrice(entity.getPrice());
        productResponse.setOldPrice(entity.getOldPrice());
        productResponse.setStockQuantity(entity.getStockQuantity());
        productResponse.setRating(entity.getRating());
        productResponse.setInStock(entity.getStockQuantity() != null && entity.getStockQuantity() > 0);
        productResponse.setDiscountPercent(calculateDiscount(entity.getPrice(), entity.getOldPrice()));
        productResponse.setStatus(entity.getStatus());
        productResponse.setSalesCount(entity.getSalesCount());
        productResponse.setReviewsCount(entity.getReviewsCount());

        if (entity.getCategory() != null) {
            productResponse.setCategoryName(entity.getCategory().getName());
        }

        if (entity.getAttributes()!= null) {
            List<ProductAttributeResponse> attributeResponses = entity.getAttributes().stream()
                    .map(ProductAttributeMapper::entityToAttribute)
                    .collect(Collectors.toList());
            productResponse.setAttributes(attributeResponses);
        }

        if (entity.getImages()!=null){
            List<ProductImageResponse> imageResponses = entity.getImages().stream()
                    .map(ProductImageMapper::entityToImage)
                    .collect(Collectors.toList());
            productResponse.setImages(imageResponses);

            productResponse.setMainImageUrl(entity.getImages().stream()
                    .filter(image -> image.getIsMain())
                    .findFirst()
                    .map(image -> image.getUrl())
                    .orElse(null));
        }
        return productResponse;

    }

    private static Integer calculateDiscount(BigDecimal price, BigDecimal oldPrice) {
        if (price == null || oldPrice == null || oldPrice.compareTo(BigDecimal.ZERO) == 0) {
            return 0;
        }

        if (oldPrice.compareTo(price) <= 0) {
            return 0;
        }

        BigDecimal discount = oldPrice.subtract(price)
                .divide(oldPrice, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return discount.intValue();
    }
}
