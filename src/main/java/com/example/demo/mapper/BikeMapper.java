package com.example.demo.mapper;

import com.example.demo.dto.BikeCreateDto;
import com.example.demo.dto.BikeResponseDto;
import com.example.demo.model.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import static org.mapstruct.ReportingPolicy.ERROR;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR, uses = ManufacturerMapper.class)
public interface BikeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "manufacturer", ignore = true)
    Bike toDomain(final BikeCreateDto dto);

    BikeResponseDto toResponseDto(final Bike bike);
}