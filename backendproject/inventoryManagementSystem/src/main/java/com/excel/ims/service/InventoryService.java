package com.excel.ims.service;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;

public interface InventoryService {

	String addUserInfo(UserDto dto);

	String userLogin(UserDto dto);

	public UserDto userGet(UserDto dto);

	UserDto updateUser(UserDto dto);

	String orderAdd(PurchaseOrderListDto dto);

	String inventoryAdd(InventoryItemsDto dto);

	Integer orderItemsAdd(PurchaseOrderItemsListDto dto);

	InventoryItemsDto inventoryItemGet(InventoryItems dto);

	InventoryItemsDto updateInventoryItems(InventoryItems dto);



}