package org.example.userservice.Controller;

import org.example.userservice.Request.SellerRequest;
import org.example.userservice.Request.UpdateUserRequest;
import org.example.userservice.Response.SellerResponse;
import org.example.userservice.Response.UserResponse;
import org.example.userservice.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final   UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponse> getProfile(@AuthenticationPrincipal(expression = "id") Long userId){
        return ResponseEntity.ok(userService.getProfile(userId));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateProfile(@RequestBody UpdateUserRequest userRequest, @AuthenticationPrincipal(expression = "id") Long userId){
        return ResponseEntity.ok(userService.updateBasicProfile(userRequest,userId));
    }

    @PostMapping
    public ResponseEntity<SellerResponse> becomeSeller(@AuthenticationPrincipal(expression = "id") Long userId, @RequestBody SellerRequest request){
        return ResponseEntity.ok(userService.becomeSeller(request,userId));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteProfile(@AuthenticationPrincipal(expression = "id") Long userId){
        userService.deleteProfile(userId);
        return ResponseEntity.noContent().build();
    }
}
