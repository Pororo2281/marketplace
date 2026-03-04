package product_service.demo.Mapper;

import product_service.demo.Entity.ProductImageEntity;
import product_service.demo.Response.ProductImageResponse;

public class ProductImageMapper {

    public static ProductImageResponse entityToImage(ProductImageEntity image) {
        ProductImageResponse response = new ProductImageResponse();
        response.setId(image.getId());
        response.setImageUrl(image.getUrl());
        response.setSortOrder(image.getSortOrder());
        return response;
    }

}
