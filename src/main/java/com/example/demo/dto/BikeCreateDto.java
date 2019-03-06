package com.example.demo.dto;

import com.example.demo.enumeration.BikeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class BikeCreateDto extends ProductDto {

    private BikeType type;
}