package dev.karthi.gym_project.controller;

import dev.karthi.gym_project.entity.Members;
import dev.karthi.gym_project.entity.Subscription;
import dev.karthi.gym_project.controller.ApiResponse;
import dev.karthi.gym_project.service.MemberService;
import dev.karthi.gym_project.service.SubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    private MemberService memService;
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> addSubscription(@RequestBody Subscription subscription) {
        try {
            Members member = memService.GetMember(subscription.getMemberId());
            if (member == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, "Invalid member ID. Cannot create subscription.", null));
            }

            Subscription saved = subscriptionService.addSubscription(subscription);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Subscription created successfully.", saved));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Subscription>> getById(@PathVariable String id) {
        try {
            Subscription subscription = subscriptionService.getSubscriptionById(id);
            if (subscription == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Subscription not found.", null));
            }
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscription found.", subscription));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Subscription>>> getAll() {
        try {
            List<Subscription> list = subscriptionService.getAllSubscriptions();
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscriptions fetched.", list));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Failed to fetch subscriptions: " + e.getMessage(), null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Subscription>> update(@PathVariable String id, @RequestBody Subscription subscription) {
        try {
            Subscription updated = subscriptionService.updateSubscription(id, subscription);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Subscription not found to update.", null));
            }
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscription updated.", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Update failed: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable String id) {
        try {
            boolean deleted = subscriptionService.deleteSubscription(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Subscription not found to delete.", null));
            }
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscription deleted.", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Deletion failed: " + e.getMessage(), null));
        }
    }
}
