package com.example.demo.service;

import javax.inject.Inject;
import java.util.UUID;

import com.example.demo.dto.BikeCreateDto;
import com.example.demo.dto.BikeResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.BikeMapper;
import com.example.demo.model.Bike;
import com.example.demo.model.Manufacturer;
import com.example.demo.repository.BikeRepository;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    private final BikeMapper bikeMapper;

    private final ManufacturerService manufacturerService;

    @Inject
    public BikeService(final BikeRepository bikeRepository,
                       final BikeMapper bikeMapper,
                       final ManufacturerService manufacturerService) {
        this.bikeRepository = bikeRepository;
        this.bikeMapper = bikeMapper;
        this.manufacturerService = manufacturerService;
    }

    public UUID create(final BikeCreateDto dto) {
        final Manufacturer manufacturer = manufacturerService.get(dto.getManufacturerId());
        final Bike bike = bikeMapper.toDomain(dto);
        bike.setManufacturer(manufacturer);

        bikeRepository.save(bike);

        return bike.getId();
    }

    public BikeResponseDto find(final UUID id) {
        final Bike bike = bikeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bike not found", id));

        return bikeMapper.toResponseDto(bike);
    }
}
