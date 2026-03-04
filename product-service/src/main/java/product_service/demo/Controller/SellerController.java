package product_service.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import product_service.demo.Enum.ProductStatus;
import product_service.demo.Request.UpdatePriceRequest;
import product_service.demo.Request.UpdateProductRequest;
import product_service.demo.Request.UpdateStockRequest;
import product_service.demo.Response.ProductImageResponse;
import product_service.demo.Response.ProductResponse;
import product_service.demo.Response.SellerStatsResponse;
import product_service.demo.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/sellers/products")
public class SellerController {

    private final ProductService service;

    public SellerController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getSellerProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "ACTIVE") ProductStatus status,
            @RequestParam(required = false) Long categoryId
            ){
        return ResponseEntity.ok(service.getSellerProducts(page, size, status, categoryId));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@RequestParam("json") String request,
                                                         @RequestParam(value = "images", required = false) List<MultipartFile> images){
        return ResponseEntity.ok(service.createProduct(request,images));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(service.getProductByIdForSeller(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody UpdateProductRequest request){
        return ResponseEntity.ok(service.updateProduct(id,request));
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<ProductResponse> publishProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.publishProduct(id));
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<ProductResponse> archiveProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.archiveProduct(id));
    }

    @PostMapping("/{id}/stock")
    public ResponseEntity<ProductResponse> updateStock(@PathVariable Long id, @RequestBody UpdateStockRequest request){
        return ResponseEntity.ok(service.updateStock(id,request));
    }

    @PostMapping("/{id}/price")
    public ResponseEntity<ProductResponse> updatePrice(@PathVariable Long id, @RequestBody UpdatePriceRequest request){
        return ResponseEntity.ok(service.updatePrice(id,request));
    }

    @PostMapping(value = "/{id}/images",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> addProductImages(@PathVariable Long id, @RequestParam("images") List<MultipartFile> images){
        return ResponseEntity.ok(service.addProductImages(id,images));
    }

    @DeleteMapping("/{id}/images/{imageId}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long id, @PathVariable Long imageId){
        service.deleteProductImage(id,imageId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/images/{imageId}/main")
    public ResponseEntity<ProductImageResponse> setMainProductImage(@PathVariable Long id, @PathVariable Long imageId){
        return ResponseEntity.ok(service.setMainProductImage(id,imageId));
    }

//    @GetMapping("/{sellerId}/stats")
//    public ResponseEntity<SellerStatsResponse> getSellerStats(@PathVariable Long sellerId){
//        return ResponseEntity.ok(service.getSellerStats(sellerId));
//    }

}
