package com.example.demo.dto;

import com.example.demo.enumeration.BallType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class BallResponseDto extends ProductResponseDto {

    private BallType type;

    private int size;
}