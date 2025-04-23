package dev.karthi.gym_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.karthi.gym_project.entity.Members;
import dev.karthi.gym_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import dev.karthi.gym_project.controller.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/gym/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<Members>> getMemberById(@PathVariable("id") String id) {
        try {
            Members member = memberService.GetMember(id);
            if (member == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Member with ID " + id + " not found.", null));
            }
            return ResponseEntity.ok(new ApiResponse<>(true, "Member fetched successfully.", member));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "An error occurred: " + e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Members>>> getAllMembers() {
        try {
            List<Members> members = memberService.getAllMembers();
            return ResponseEntity.ok(new ApiResponse<>(true, "All members fetched successfully.", members));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "An error occurred: " + e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Members>> AddMembers(@RequestBody Members mem) {
        try {
            Members saved = memberService.AddNewMember(mem);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true, "Member added successfully", saved));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Failed to add member: " + e.getMessage(), null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Members>> updateMember(@RequestBody Members mem) {
        try {
            Members existingMember = memberService.GetMember(mem.getId());
            if (existingMember == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "Member not found.", null));
            }

            existingMember.setFirstName(mem.getFirstName());
            existingMember.setLastName(mem.getLastName());
            existingMember.setEmail(mem.getEmail());
            existingMember.setPhoneNumber(mem.getPhoneNumber());
            existingMember.setGender(mem.getGender());
            existingMember.setDateOfBirth(mem.getDateOfBirth());
            existingMember.setAddress(mem.getAddress());
            existingMember.setCity(mem.getCity());
            existingMember.setCountry(mem.getCountry());
            existingMember.setPostalCode(mem.getPostalCode());
            existingMember.setActive(mem.isActive());
            existingMember.setUpdatedAt(LocalDateTime.now());

            Members updated = memberService.AddNewMember(existingMember);
            return ResponseEntity.ok(new ApiResponse<>(true, "Member updated successfully.", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error while updating: " + e.getMessage(), null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> findMembers(
            @RequestParam String firstName,
            @RequestParam(required = false) String lastName) {
        try {
            if (lastName != null && !lastName.isEmpty()) {
                Members member = memberService.GetByName(firstName, lastName);
                if (member == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ApiResponse<>(false, "No member found with name: " + firstName + " " + lastName, null));
                }
                return ResponseEntity.ok(new ApiResponse<>(true, "Member found.", member));
            } else {
                List<Members> members = memberService.getByName(firstName);
                if (members.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ApiResponse<>(false, "No members found with first name: " + firstName, null));
                }
                return ResponseEntity.ok(new ApiResponse<>(true, "Members found.", members));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error occurred: " + e.getMessage(), null));
        }
    }
    
    
    
    
    
    
    
}
