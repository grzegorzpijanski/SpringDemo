package com.example.demo.service;

import javax.inject.Inject;

import java.util.UUID;

import com.example.demo.dto.BallCreateDto;
import com.example.demo.dto.BallResponseDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.BallMapper;
import com.example.demo.model.Ball;
import com.example.demo.model.Manufacturer;
import com.example.demo.repository.BallRepository;
import org.springframework.stereotype.Service;

@Service
public class BallService {

    private final BallRepository ballRepository;

    private final BallMapper ballMapper;

    private final ManufacturerService manufacturerService;

    @Inject
    public BallService(final BallRepository ballRepository,
                       final BallMapper ballMapper,
                       final ManufacturerService manufacturerService) {
        this.ballRepository = ballRepository;
        this.ballMapper = ballMapper;
        this.manufacturerService = manufacturerService;
    }

    public UUID add(final BallCreateDto dto) {
        final Manufacturer manufacturer = manufacturerService.get(dto.getManufacturerId());
        final Ball ball = ballMapper.toDomain(dto);
        ball.setManufacturer(manufacturer);

        ballRepository.save(ball);

        return ball.getId();
    }

    public BallResponseDto find(final UUID id) {
        final Ball ball = ballRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ball not found", id));

        return ballMapper.toResponseDto(ball);
    }
}