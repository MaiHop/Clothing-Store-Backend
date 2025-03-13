package com.maihop.identify.service.controller;

import com.maihop.identify.service.dto.request.AuthenticationRequest;
import com.maihop.identify.service.dto.request.IntrospectRequest;
import com.maihop.identify.service.dto.request.LogoutRequest;
import com.maihop.identify.service.dto.request.RefreshRequest;
import com.maihop.identify.service.dto.respone.ApiResponse;
import com.maihop.identify.service.dto.respone.AuthenticationResponse;
import com.maihop.identify.service.dto.respone.IntrospectResponse;
import com.maihop.identify.service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var ressult = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(ressult)
                .build();
    }

    @PostMapping("/log-out")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);

        return ApiResponse.<Void>builder()
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var ressult = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .result(ressult)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        var ressult = authenticationService.refreshToken(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(ressult)
                .build();
    }
}
