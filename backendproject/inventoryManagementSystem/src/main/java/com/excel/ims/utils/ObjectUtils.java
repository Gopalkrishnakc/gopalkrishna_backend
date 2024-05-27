package com.excel.ims.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.PurchaseOrderItemsDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrderItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;

public class ObjectUtils {

	public static User userDtoToEntitiy(UserDto dto) {
	
		return User.builder().username(dto.getUsername())
				.email(dto.getEmail()).password(dto.getPassword())
				.build();
	}

	public static UserDto userEntityToDto(User user) {
	
		return UserDto.builder().userId(user.getUserId())
				.username(user.getUsername()).email(user.getEmail())
				.createdAt(user.getCreatedAt()).password(user.getPassword()).isAdmin(user.isAdmin()).build();
	}

	public static User updateValues(User user, UserDto dto) {
			user.setUsername(dto.getUsername());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			
			user.setAdmin(user.isAdmin());
			return user;
	}

	public static List<PurchaseOrders> ordersDtoToEntity(List<PurchaseOrderDto> orders) {
	
		return orders.stream().map(order->PurchaseOrders.builder()
				.supplier(order.getSupplier()).status(order.getStatus())
				.build()).collect(Collectors.toList());
	}

	public static InventoryItems itemsDtoToEntity(InventoryItemsDto dto) {
		
		return InventoryItems .builder().itemName(dto.getItemName()).description(dto.getDescription())
				.category(dto.getCategory()).unitPrice(dto.getUnitPrice())
				.quantityOnHand(dto.getQuantityOnHand())
				.reorderPoint(dto.getReorderPoint()).createdAt(dto.getCreatedAt()).build();
	}

	public static List<PurchaseOrderItems> orderItemsDtoToEntity(List<PurchaseOrderItemsDto> orderItems) {
	
		return orderItems.stream().map(m->PurchaseOrderItems.builder()
				.quantity(m.getQuantity()).unitPrice(m.getUnitPrice()).build()).collect(Collectors.toList());
	}

	public static InventoryItemsDto itemsEntityToDto(InventoryItems items) {
		
		return InventoryItemsDto.builder().itemId(items.getItemId()).itemName(items.getItemName())
				.description(items.getDescription()).category(items.getCategory())
				.unitPrice(items.getUnitPrice()).reorderPoint(items.getReorderPoint())
				.quantityOnHand(items.getQuantityOnHand()).build();
	}

	public static InventoryItems updateValues(InventoryItems item, InventoryItems dto) {
		item.setItemName(dto.getItemName());
		item.setDescription(dto.getDescription());
		item.setCreatedAt(LocalDate.now());
		item.setCategory(dto.getCategory());
		item.setUnitPrice(dto.getUnitPrice());
		item.setQuantityOnHand(dto.getQuantityOnHand());
		return item;
	}

}


