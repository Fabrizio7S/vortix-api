package com.vortix.vortix_api;

import com.vortix.vortix_api.core.user.enums.UserRole;
import com.vortix.vortix_api.core.user.enums.UserStatus;
import com.vortix.vortix_api.core.user.service.UserService;
import com.vortix.vortix_api.core.user.web.request.CreateUserRequest;
import com.vortix.vortix_api.core.user.web.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class VortixApiApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void shouldCreateUserSuccessfully() {

		// Arrange
		Long businessId = 1L;

		CreateUserRequest request = new CreateUserRequest(
				"test.vortix3@gmail.com",
				"Password123",
				UserRole.SELLER
		);

		// Act
		UserResponse response = userService.create(businessId, request);

		// Assert
		assertNotNull(response);
		assertNotNull(response.id());
		assertEquals(request.email(), response.email());
		assertEquals(UserRole.SELLER, response.role());
		assertEquals(UserStatus.ACTIVE, response.status());
	}

}
