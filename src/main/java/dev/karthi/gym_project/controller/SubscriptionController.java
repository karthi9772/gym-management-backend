package dev.karthi.gym_project.controller;

import dev.karthi.gym_project.entity.Subscription;
import dev.karthi.gym_project.service.SubscriptionService;
import dev.karthi.gym_project.service.MemberService;
import dev.karthi.gym_project.entity.Members;
import dev.karthi.gym_project.controller.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> addSubscription(@RequestBody Subscription sub) {
        try {
            Members member = memberService.GetMember(sub.getMemberId());
            if (member == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, "Invalid member ID.", null));
            }

            Subscription saved = subscriptionService.addSubscription(sub);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Subscription created.", saved));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error: " + e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getById(@PathVariable String id) {
        Subscription sub = subscriptionService.getSubscriptionById(id);
        if (sub == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Subscription not found.", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, "Subscription found.", sub));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<?>> getAll() {
        List<Subscription> list = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(new ApiResponse<>(true, "All subscriptions.", list));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable String id, @RequestBody Subscription sub) {
        try {
            Subscription updated = subscriptionService.updateSubscription(id, sub);
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscription updated.", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Update error: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable String id) {
        try {
            subscriptionService.deleteSubscription(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Subscription deleted.", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Delete error: " + e.getMessage(), null));
        }
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<ApiResponse<?>> getByMemberId(@PathVariable String memberId) {
        List<Subscription> list = subscriptionService.getSubscriptionsByMemberId(memberId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Subscriptions for member.", list));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<?>> getActiveSubscriptions() {
        List<Subscription> list = subscriptionService.getActiveSubscriptions();
        return ResponseEntity.ok(new ApiResponse<>(true, "Active subscriptions.", list));
    }

    @GetMapping("/expired")
    public ResponseEntity<ApiResponse<?>> getExpiredSubscriptions() {
        List<Subscription> list = subscriptionService.getExpiredSubscriptions();
        return ResponseEntity.ok(new ApiResponse<>(true, "Expired subscriptions.", list));
    }

    @GetMapping("/ending-soon")
    public ResponseEntity<ApiResponse<?>> getEndingSoonSubscriptions() {
        List<Subscription> list = subscriptionService.getSubscriptionsEndingSoon();
        return ResponseEntity.ok(new ApiResponse<>(true, "Subscriptions ending soon.", list));
    }
}
