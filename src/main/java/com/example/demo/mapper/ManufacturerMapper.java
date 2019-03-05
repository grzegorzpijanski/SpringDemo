package com.example.demo.mapper;

import com.example.demo.dto.ManufacturerCreateDto;
import com.example.demo.dto.ManufacturerResponseDto;
import com.example.demo.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import static org.mapstruct.ReportingPolicy.ERROR;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ERROR)
public interface ManufacturerMapper {

    @Mapping(target = "id", ignore = true)
    Manufacturer toDomain(final ManufacturerCreateDto dto);

    ManufacturerResponseDto toResponseDto(final Manufacturer manufacturer);
}