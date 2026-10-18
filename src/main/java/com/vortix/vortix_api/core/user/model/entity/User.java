package com.vortix.vortix_api.core.user.model.entity;


import com.vortix.vortix_api.core.business.entity.Business;
import com.vortix.vortix_api.core.user.model.enums.UserRole;
import com.vortix.vortix_api.core.user.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "user_account")
@Getter
@RequiredArgsConstructor(access =  AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email",nullable = false )
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    public void update(String email, String password){
        this.email = email;
        this.password = password;
    }
}
