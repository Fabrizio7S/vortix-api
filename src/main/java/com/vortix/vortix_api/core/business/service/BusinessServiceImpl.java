package com.vortix.vortix_api.core.business.service;

import com.vortix.vortix_api.core.business.component.BusinessMapper;
import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.business.exception.BusinessNotFoundException;
import com.vortix.vortix_api.core.business.repository.BusinessRepository;
import com.vortix.vortix_api.core.business.web.request.CreateBusinessRequest;
import com.vortix.vortix_api.core.business.web.request.UpdateBusinessRequest;
import com.vortix.vortix_api.core.business.web.response.BusinessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Locale;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService{

    private final BusinessRepository businessRepository;
    private final BusinessMapper businessMapper;

    @Override
    @Transactional(readOnly = true)
    public Business findEntityById(long id) {
        return  businessRepository.findById(id)
                .orElseThrow(() -> new BusinessNotFoundException(id));
    }

    @Override
    @Transactional
    public BusinessResponse create(CreateBusinessRequest request) {
        String code = generateCode(request.name());
        Business business = Business.builder()
                .code(code)
                .name(request.name())
                .startDate(LocalDate.now())
                .build();
        Business savedBusiness = businessRepository.save(business);
        return businessMapper.toResponse(savedBusiness);
    }

    @Override
    @Transactional
    public BusinessResponse update(Long id, UpdateBusinessRequest request) {
        Business business = findEntityById(id);
        business.update(
                request.name()
        );
        return  businessMapper.toResponse(business);
    }
    private String generateCode(String name) {
        String baseCode = name.toLowerCase(Locale.ROOT)
                .trim()
                .replaceAll("\\s+", "-");

        String code = baseCode;
        int counter = 2;

        while (businessRepository.existsByCode(code)) {
            code = baseCode + "-" + counter;
            counter++;
        }

        return code;
    }
}
