package com.example.demo.service;

import java.util.UUID;

import com.example.demo.dto.ManufacturerCreateDto;
import com.example.demo.dto.ManufacturerResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.ManufacturerMapper;
import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    public ManufacturerService(final ManufacturerRepository manufacturerRepository,
                               final ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    public UUID add(final ManufacturerCreateDto dto) {
        final Manufacturer manufacturer = manufacturerMapper.toDomain(dto);

        manufacturerRepository.save(manufacturer);

        return manufacturer.getId();
    }

    public ManufacturerResponseDto find(final UUID manufacturerId) {
        final Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NotFoundException("Manufacturer not found", manufacturerId));

        return manufacturerMapper.toResponseDto(manufacturer);
    }

    Manufacturer get(final UUID manufacturerId) {
        return manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NotFoundException("Manufacturer not found", manufacturerId));
    }
}