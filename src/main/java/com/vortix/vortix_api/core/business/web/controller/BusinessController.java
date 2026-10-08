package com.vortix.vortix_api.core.business.web.controller;

import com.vortix.vortix_api.core.business.service.BusinessService;
import com.vortix.vortix_api.core.business.web.request.CreateBusinessRequest;
import com.vortix.vortix_api.core.business.web.request.UpdateBusinessRequest;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessResponse create(@Valid @RequestBody CreateBusinessRequest request) {
        return businessService.create(request);
    }

    @PutMapping("/{id}")
    public  BusinessResponse update (@PathVariable Long id, @Valid @RequestBody UpdateBusinessRequest request) {
        return businessService.update(id, request);
    }


}
