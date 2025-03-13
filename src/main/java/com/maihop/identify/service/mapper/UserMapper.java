package com.maihop.identify.service.mapper;

import com.maihop.identify.service.dto.request.UserCreationRequest;
import com.maihop.identify.service.dto.request.UserUpdateRequest;
import com.maihop.identify.service.dto.respone.UserResponse;
import com.maihop.identify.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    @Mapping(source = "firstName", target = "lastName")
    UserResponse toUserRespone(User user);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
