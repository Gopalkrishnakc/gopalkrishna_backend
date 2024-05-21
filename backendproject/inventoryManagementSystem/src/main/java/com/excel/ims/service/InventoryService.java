package com.excel.ims.service;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;

public interface InventoryService {

	String addUserInfo(UserDto dto);

	String userLogin(UserDto dto);

	public UserDto userGet(UserDto dto);

	UserDto updateUser(UserDto dto);

	String orderAdd(PurchaseOrderListDto dto);

	String inventoryAdd(InventoryItemsDto dto);

	String orderItemsAdd(PurchaseOrderItemsListDto dto);



}
