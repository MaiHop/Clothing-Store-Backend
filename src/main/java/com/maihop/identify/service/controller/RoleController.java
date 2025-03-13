package com.maihop.identify.service.controller;

import com.maihop.identify.service.dto.request.RoleRequest;
import com.maihop.identify.service.dto.respone.ApiResponse;
import com.maihop.identify.service.dto.respone.RoleResponse;
import com.maihop.identify.service.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        var ressult = roleService.create(request);

        return ApiResponse.<RoleResponse>builder()
                .result(ressult)
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll(){
        ApiResponse<List<RoleResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(roleService.getAll());
        return apiResponse;
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete(@PathVariable String role){
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}
