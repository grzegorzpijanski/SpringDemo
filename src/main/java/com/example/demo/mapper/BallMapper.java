package com.example.demo.mapper;

import com.example.demo.dto.BallCreateDto;
import com.example.demo.dto.BallResponseDto;
import com.example.demo.model.Ball;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import static org.mapstruct.ReportingPolicy.ERROR;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR, uses = ManufacturerMapper.class)
public interface BallMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    Ball toDomain(final BallCreateDto dto);

    BallResponseDto toResponseDto(final Ball ball);
}