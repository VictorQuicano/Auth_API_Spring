package com.nerdery.auth.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="branches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Branch extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{validation.required}")
    @Size(min = 2, max = 100, message = "{validation.size}")
    @Column(nullable = false, length = 100)
    private String name;

    
    @NotBlank(message = "{validation.required}")
    @Size(min = 2, max = 255, message = "{validation.size}")
    @Column(nullable = false, length = 255)
    private String address;

}
