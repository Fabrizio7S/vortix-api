package com.vortix.vortix_api.core.user.repository;

import com.vortix.vortix_api.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByBusiness_IdAndEmail(
            Long businessId,
            String email
    );
}
