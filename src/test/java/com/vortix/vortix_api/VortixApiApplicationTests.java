package com.vortix.vortix_api;

import com.vortix.vortix_api.core.business.service.BusinessService;
import com.vortix.vortix_api.core.business.web.request.CreateBusinessRequest;
import com.vortix.vortix_api.core.business.web.request.UpdateBusinessRequest;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VortixApiApplicationTests {

	@Autowired
	private BusinessService businessService;

	@Test
	void updateBusiness() {

		UpdateBusinessRequest request = new UpdateBusinessRequest("Bodega Fabrizio SAC");

		BusinessResponse response = businessService.update(1L, request);

		System.out.println("ID: " + response.id());
		System.out.println("Nombre actualizado: " + response.name());
	}

}
