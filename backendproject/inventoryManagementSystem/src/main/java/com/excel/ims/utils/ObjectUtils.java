package com.excel.ims.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;

public class ObjectUtils {

	public static User userDtoToEntitiy(UserDto dto) {
	
		return User.builder().username(dto.getUserName())
				.email(dto.getEmail()).password(dto.getPassword())
				.createdAt(dto.getCreatedAt()).build();
	}

	public static UserDto userEntityToDto(User user) {
	
		return UserDto.builder().userId(user.getUserId())
				.userName(user.getUsername()).email(user.getEmail())
				.password(user.getPassword()).createdAt(user.getCreatedAt()).isAdmin(user.isAdmin()).build();
	}

	public static User updateValues(User user, UserDto dto) {
		
			

			user.setUsername(dto.getUserName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setCreatedAt(dto.getCreatedAt());
			user.setAdmin(user.isAdmin());
			return user;


		
	}

	public static List<PurchaseOrders> ordersDtoToEntity(List<PurchaseOrderDto> orders) {
	
		return orders.stream().map(order->PurchaseOrders.builder().orderDate(order.getOrderDate())
				.supplier(order.getSupplier()).status(order.getStatus())
				.createdAt(order.getCreatedAt()).build()).collect(Collectors.toList());
	}

	public static InventoryItems itemsDtoToEntity(InventoryItemsDto dto) {
		// TODO Auto-generated method stub
		return InventoryItems .builder().itemname(dto.getItemName()).description(dto.getDescription())
				.category(dto.getCategory()).unit_price(dto.getUnitPrice())
				.quantityOnHand(dto.getQuantityOnHand()).created_at(dto.getCreatedAt())
				.reorderPoint(dto.getReorderPoint()).build();
	}

}


