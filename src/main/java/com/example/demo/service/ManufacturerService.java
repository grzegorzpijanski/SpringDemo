package com.example.demo.service;

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

    public void add(final ManufacturerCreateDto dto) {
        final Manufacturer manufacturer = manufacturerMapper.toDomain(dto);

        manufacturerRepository.save(manufacturer);
    }

    public ManufacturerResponseDto find(final long manufacturerId) {
        final Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(NotFoundException::new);

        return manufacturerMapper.toResponseDto(manufacturer);
    }
}