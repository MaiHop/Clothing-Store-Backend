package com.maihop.identify.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.maihop.identify.service.dto.request.UserCreationRequest;
import com.maihop.identify.service.dto.respone.UserResponse;
import com.maihop.identify.service.entity.User;
import com.maihop.identify.service.exception.AppException;
import com.maihop.identify.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    @BeforeEach
    public void initData(){
        dob = LocalDate.of(2002,1,1);

        request = UserCreationRequest.builder()
                .username("mai1")
                .firstName("mai")
                .lastName("hop")
                .password("123456789")
                .dob(dob)
                .build();

        userResponse = UserResponse.builder()
                .id("sdfsdfsdfsdfddsf")
                .username("mai1")
                .firstName("mai")
                .lastName("hop")
                .dob(dob)
                .build();

        user = User.builder()
                .id("sdfsdfsdfsdfddsf")
                .username("mai1")
                .firstName("mai")
                .lastName("hop")
                .dob(dob)
                .build();
    }


    @Test
    void createUser_validRequest_success() throws Exception {
        //GIVEN
        when(userRepository.existsByUsername(anyString()))
                .thenReturn(false);
        when(userRepository.save(any()))
                .thenReturn(user);

        //WHEN,THEN
        var respone =  userService.createUser(request);

        //THEN
        Assertions.assertThat(respone.getId()).isEqualTo("sdfsdfsdfsdfddsf");
        Assertions.assertThat(respone.getUsername()).isEqualTo("mai1");

    }

    @Test
    void createUser_userExisted_fail() throws Exception {
        //GIVEN
        when(userRepository.existsByUsername(anyString()))
                .thenReturn(true);

        //WHEN,THEN
        var exception = org.junit.jupiter.api.Assertions.assertThrows(AppException.class, () -> userService.createUser(request));

        //THEN

        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1004);

    }

    @Test
    @WithMockUser(username = "mai1")
    void getMyInfo_valid_success() throws Exception {
        //GIVEN
        when(userRepository.findByUsername(anyString()))
                .thenReturn(Optional.of(user));

        //WHEN,THEN
        var respone =  userService.getMyInfo();

        //THEN

        Assertions.assertThat(respone.getUsername()).isEqualTo("mai1");
        Assertions.assertThat(respone.getId()).isEqualTo("sdfsdfsdfsdfddsf");

    }

    @Test
    @WithMockUser(username = "mai1")
    void getMyInfo_userNotFound_fail() throws Exception {
        //GIVEN
        when(userRepository.findByUsername(anyString()))
                .thenReturn(Optional.ofNullable(null));

        //WHEN
        var exception = org.junit.jupiter.api.Assertions.assertThrows(AppException.class, () -> userService.getMyInfo());

        //THEN

        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1005);

    }

}
