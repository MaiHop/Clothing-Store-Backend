package com.maihop.identify.service.controller;

import com.maihop.identify.service.dto.request.PermissionRequest;
import com.maihop.identify.service.dto.respone.*;
import com.maihop.identify.service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionRespone> create(@RequestBody PermissionRequest request){
        var ressult = permissionService.create(request);

        return ApiResponse.<PermissionRespone>builder()
                .result(ressult)
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionRespone>> getAll(){
        ApiResponse<List<PermissionRespone>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(permissionService.getAll());
        return apiResponse;
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete(@PathVariable String permission){
        permissionService.delete(permission);
        return ApiResponse.<Void>builder().build();
    }
}
