package com.excel.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;
import com.excel.ims.repository.InventoryRepository;
import com.excel.ims.repository.UserRepository;
import com.excel.ims.utils.ObjectUtils;

@Service
public class InventorySErviceImple implements InventoryService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public String addUserInfo(UserDto dto) {
		if(!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			User user=ObjectUtils.userDtoToEntitiy( dto);
			user.setAdmin(true);
			User user1=userRepository.save(user);
			return user.getEmail();
		}
		return "user is already present";
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
	       return "Invalid username"; 
	}

	@Override
	public UserDto userGet(UserDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			UserDto user1=ObjectUtils.userEntityToDto(user);
			return user1;
		}
		return null;
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
		return null;
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
		return null;
	}

	@Override
	public String inventoryAdd(InventoryItemsDto dto) {
		if(!inventoryRepository.findByItemname(dto.getItemName()).isPresent()) {
			InventoryItems items=ObjectUtils.itemsDtoToEntity(dto);
			InventoryItems item=inventoryRepository.save(items);
			return items.getItemname();
		}
		return "data is already present";
	}

	

}
