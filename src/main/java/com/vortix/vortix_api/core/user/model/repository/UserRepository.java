package com.vortix.vortix_api.core.user.model.repository;

import com.vortix.vortix_api.core.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
