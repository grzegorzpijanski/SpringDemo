package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

import com.example.demo.enumeration.BallType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class BallCreateDto extends ProductDto {

    private BallType type;

    @Max(10)
    @PositiveOrZero
    private int size;
}