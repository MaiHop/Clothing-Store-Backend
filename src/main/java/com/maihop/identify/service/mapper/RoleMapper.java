package com.maihop.identify.service.mapper;

import com.maihop.identify.service.dto.request.RoleRequest;
import com.maihop.identify.service.dto.respone.RoleResponse;
import com.maihop.identify.service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
//    @Mapping(target = "permissions", ignore = true)
    RoleResponse toRoleResponse(Role role);
}
