package com.nerdery.auth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//import lombok.Getter;
//import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;

import jakarta.persistence.Column;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "products")
@Data                    // ← Getters, Setters, toString, equals, hashCode
@NoArgsConstructor       // ← Empty Constructor (required by JPA)
@AllArgsConstructor      // ← Constructor with all fields  
@Builder                 // ← Builder pattern for flexible creation

public class Product extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "{validation.required}")
    @Size(min = 2, max = 100, message = "{validation.size}")
    @Column(nullable = false, length = 100)
    private String name;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "{validation.decimal.min}")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    
    @Min(value = 0, message ="{validation.min}")
    @Column(nullable = false)
    private Integer stock;
    
}
