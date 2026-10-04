package com.vortix.vortix_api.core.business.repository;

import com.vortix.vortix_api.core.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business,Long> {

}
