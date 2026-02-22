package org.example.userservice.Controller;

import org.example.userservice.Request.SellerRequest;
import org.example.userservice.Response.SellerResponse;
import org.example.userservice.Service.SellerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
public class SellerProfileController {

    private final SellerProfileService  service;



    public SellerProfileController(SellerProfileService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> getSellerProfile(@PathVariable Long id){
        return ResponseEntity.ok(service.getSellerProfile(id));
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<SellerResponse> getSellerStats(@PathVariable Long id){
        return ResponseEntity.ok(service.getSellerStats(id));
    }

    @PutMapping
    public ResponseEntity<SellerResponse> updateSellerProfile(
            @AuthenticationPrincipal(expression = "id") Long userId,
            @RequestBody SellerRequest sellerRequest)
    {
        return ResponseEntity.ok(service.updateSellerProfile(userId,sellerRequest));
    }
}
