package com.khaind.microservices.order.mapper;

import com.khaind.microservices.order.dto.OrderDTO;
import com.khaind.microservices.order.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(OrderDTO dto);

    OrderDTO toDTO(OrderEntity entity);

    List<OrderEntity> toEntities(List<OrderDTO> dtos);

    List<OrderDTO> toDTOs(List<OrderEntity> entities);
}
