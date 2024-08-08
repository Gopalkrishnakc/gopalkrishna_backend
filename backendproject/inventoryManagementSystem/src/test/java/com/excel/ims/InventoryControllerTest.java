
package com.excel.ims;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.excel.ims.commomrespose.CommonResponse;
import com.excel.ims.controller.InventroryController;
import com.excel.ims.dto.UserDto;
import com.excel.ims.service.InventoryService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class InventoryControllerTest {

	@SpyBean
	private InventoryService inventoryService;

	@InjectMocks
	private InventroryController inventoryController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@Order(1)
	public void testPostUserData() throws Exception {
		UserDto dto = new UserDto();
		dto.setEmail("johnreddy8081@example.com");
		dto.setAdmin(false);
		dto.setPassword("John@8081");
		dto.setUsername("jacke");
		when(inventoryService.addUserInfo(dto)).thenReturn(dto.getEmail());

		System.out.println("Mock setup complete, calling addUserInfo...");

		ResponseEntity<CommonResponse<String>> responseEntity = inventoryController.addUserInfo(dto);

		System.out.println("Method call completed.");

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		CommonResponse<String> responseBody = responseEntity.getBody();
		assertNotNull(responseBody);
		assertEquals("johnreddy8081@example.com", responseBody.getData());
		assertEquals("User_INFO_SAVED", responseBody.getMessage());
		assertFalse(responseBody.isError());
	}

	@Test
	@Order(2)
	public void putUserData() throws Exception {
		UserDto dto = new UserDto();
		dto.setEmail("johnreddy8081@example.com");
		dto.setAdmin(false);
		dto.setPassword("Johny@76");
		dto.setUsername("Johny");
		when(inventoryService.updateUser(dto)).thenReturn(dto);
		ResponseEntity<CommonResponse<UserDto>> updateUser = inventoryController.updateUser(dto);
		assertEquals(HttpStatus.OK, updateUser.getStatusCode());
		CommonResponse<UserDto> response = updateUser.getBody();
		assertNotNull(response);
		assertEquals(dto, response.getData());
		assertEquals("USER_UPDATE_SUCCESS", response.getMessage());
		assertFalse(response.isError());
	}

	@Test
	@Order(3)
	public void testDeleteUser() {
		UserDto dto = UserDto.builder().email("johnreddy8081@example.com").build();
		when(inventoryService.deleteUser(dto)).thenReturn("User Deleted Successfully");
		ResponseEntity<CommonResponse<String>> deletedUser = inventoryController.deleteUser(dto);
		assertEquals(HttpStatus.OK, deletedUser.getStatusCode());
		CommonResponse<String> res = deletedUser.getBody();
		assertNotNull(res);
		assertEquals("User Deleted Successfully", res.getData());
		assertEquals("USER_DELETED_SUCCESS", res.getMessage());
		assertEquals(false, res.isError());
	}

	@Test
	@Order(4)
	public void testGetall() {
		UserDto dto1 = UserDto.builder().email("johnreddy8081@example.com").password("Johny@76").username("Johny")
				.isAdmin(false).build();
		UserDto dto2 = new UserDto();
		dto2.setEmail("johnreddy8081@example.com");
		dto2.setAdmin(false);
		dto2.setPassword("John@8081");
		dto2.setUsername("jacke");
		List<UserDto> users = Arrays.asList(dto1, dto2);
		when(inventoryService.userGetAll()).thenReturn(users);
		ResponseEntity<CommonResponse<List<UserDto>>> getUsers = inventoryController.userGetAll();
		assertEquals(HttpStatus.OK, getUsers.getStatusCode());
		CommonResponse<List<UserDto>> res = getUsers.getBody();
		assertNotNull(res);
		assertThat(res.getData()).isEqualTo(users);
		assertEquals("ALL_USERS_FETCHED_SUCCESSFULLY", res.getMessage());
		assertFalse(res.isError());

	}

}
