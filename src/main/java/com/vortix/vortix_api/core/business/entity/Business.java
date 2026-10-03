package com.vortix.vortix_api.core.business.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "business")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public void update(String name) {
        this.name = name;
    }
}
