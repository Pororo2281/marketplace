package product_service.demo.Controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import product_service.demo.Request.CheckAvailabilityRequest;
import product_service.demo.Response.CheckAvailabilityResponse;
import product_service.demo.Response.ProductResponse;
import product_service.demo.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/internal")
public class InternalController {

    private final product_service.demo.service.InternalProductService service;
    public InternalController(product_service.demo.service.InternalProductService service) {
        this.service = service;
    }

    @PostMapping("products/check-availability")
    public ResponseEntity<CheckAvailabilityResponse> checkProductAvailability(@RequestBody CheckAvailabilityRequest request){
        return ResponseEntity.ok(service.checkAvailability(request));
    }

    @PostMapping("/products/reserve-stock")
    public ResponseEntity<Void> reverseStock(@RequestBody CheckAvailabilityRequest request){
        boolean reserved = service.reserveStock(request);
        if (!reserved){
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products/reduce-stock")
    public ResponseEntity<Void> reduceStock(@RequestBody CheckAvailabilityRequest request) {
        service.reduceStock(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/return-stock")
    public ResponseEntity<Void> returnStock(@RequestBody CheckAvailabilityRequest request) {
        service.returnStock(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("products/batch")
    public ResponseEntity<List<ProductResponse>> getProductsBatch(@RequestParam List<Long> ids){
        return ResponseEntity.ok(service.getProductsBatch(ids));
    }
}
