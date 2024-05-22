package com.excel.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrderItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;
import com.excel.ims.exception.NoUserFoundException;
import com.excel.ims.repository.InventoryRepository;
import com.excel.ims.repository.PurchaseOrderRepository;
import com.excel.ims.repository.UserRepository;
import com.excel.ims.utils.ObjectUtils;

@Service
public class InventoryServiceImple implements InventoryService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private  PurchaseOrderRepository purchaseOrderRepository;

	@Override
	public String addUserInfo(UserDto dto) {
		if(!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			User user=ObjectUtils.userDtoToEntitiy( dto);
			user.setAdmin(true);
			User user1=userRepository.save(user);
			return user.getEmail();
		}
		 throw new  NoUserFoundException("USER_ALREDY_FOUND");
	}

	@Override
	public String userLogin(UserDto dto) {
		 Optional<User> optional = userRepository.findByEmail(dto.getEmail());
	       if (optional.isPresent()) {
	           User user = optional.get();
	           if (user.getPassword().equals(dto.getPassword())) {
	               return user.getUsername();
	           } else {
	               return "Incorrect password";
	           }
	       }
	       throw new  NoUserFoundException("INVALID_USER_NAME"); 
	}

	@Override
	public UserDto userGet(UserDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			UserDto user1=ObjectUtils.userEntityToDto(user);
			return user1;
		}
		 throw new  NoUserFoundException("NO_USER_FOUND");
	}

	@Override
	public UserDto updateUser(UserDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			user=ObjectUtils.updateValues(user,dto);
			User save=userRepository.save(user);
			return ObjectUtils.userEntityToDto(save);
		}
		 throw new  NoUserFoundException("NO_Email_FOUND");
	}

	@Override
	public String orderAdd(PurchaseOrderListDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			List<PurchaseOrders> purchaseOrders=ObjectUtils.ordersDtoToEntity(dto.getOrders());
			user.setPurchaseOrders(purchaseOrders);
			purchaseOrders.stream().forEach(x->x.setUserTable(user));
			return userRepository.save(user).getEmail();
		}
		 throw new  NoUserFoundException("NO_ORDERS_FOUND");
	}

	@Override
	public String inventoryAdd(InventoryItemsDto dto) {
		if(!inventoryRepository.findByItemId(dto.getItemId()).isPresent()) {
			InventoryItems items=ObjectUtils.itemsDtoToEntity(dto);
			InventoryItems item=inventoryRepository.save(items);
			return items.getItemname();
		}
		 throw new  NoUserFoundException("ITEM_ALREDAY_FOUND");
	}

	@Override
	public Integer orderItemsAdd(PurchaseOrderItemsListDto dto) {
		Optional<InventoryItems> inventoryOptional=inventoryRepository.findByItemId(dto.getItemId());
		Optional<PurchaseOrders> orderOptional= purchaseOrderRepository.findBySupplier(dto.getSupplier());
		if(inventoryOptional.isPresent()&& orderOptional.isPresent()) {
			InventoryItems items=inventoryOptional.get();
			PurchaseOrders orders=orderOptional.get();
			List<PurchaseOrderItems> purchaseOrderItems=ObjectUtils.orderItemsDtoToEntity(dto.getOrderItems());
			items.setPurchaseOrdersItems(purchaseOrderItems);
			orders.setPurchaseOrdersItems(purchaseOrderItems);
			 purchaseOrderItems.stream().forEach(x->x.setInventoryItems(items));
			 purchaseOrderItems.stream().forEach(x->x.setPurchaseOrders(orders));
			 PurchaseOrders orders1=purchaseOrderRepository.save(orders);
			 return inventoryRepository.save(items).getItemId();
		}
		 throw new  NoUserFoundException("ITEM_NOT_FOUND");
	}

	@Override
	public InventoryItemsDto inventoryItemGet(InventoryItems dto) {
		Optional<InventoryItems>optional=inventoryRepository.findByItemId(dto.getItemId());
		if(optional.isPresent()) {
		InventoryItems items=optional.get();
		InventoryItemsDto dtos=ObjectUtils.itemsEntityToDto(items);
		return dtos;
		}
		 throw new  NoUserFoundException("DATA_NOT_FOUND");
	}

	@Override
	public InventoryItemsDto updateInventoryItems(InventoryItems dto) {
		Optional<InventoryItems>optional=inventoryRepository.findByItemId(dto.getItemId());
		if(optional.isPresent()) {
			InventoryItems item=optional.get();
			item=ObjectUtils.updateValues(item,dto);
			InventoryItems save=inventoryRepository.save(item);
			return ObjectUtils.itemsEntityToDto(save);
		} 
		 throw new  NoUserFoundException("ITEM_NAME_NOT_FOUND");
	}


	

}
