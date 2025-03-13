package com.maihop.identify.service.mapper;

import com.maihop.identify.service.dto.request.PermissionRequest;
import com.maihop.identify.service.dto.respone.PermissionRespone;
import com.maihop.identify.service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionRespone toPermissionRespone(Permission permission);
}
