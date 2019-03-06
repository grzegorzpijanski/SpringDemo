package com.example.demo.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.UUID;

import com.example.demo.dto.BikeCreateDto;
import com.example.demo.dto.BikeResponseDto;
import com.example.demo.service.BikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    @Inject
    public BikeController(final BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @ApiOperation("Allows to add a bike")
    @PostMapping
    public ResponseEntity<UUID> add(@Valid @RequestBody final BikeCreateDto dto) {
        final UUID id = bikeService.add(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @ApiOperation("Allows to get find a bike by id")
    @GetMapping("/{bikeId}")
    public ResponseEntity<BikeResponseDto> find(@PathVariable final UUID bikeId) {
        final BikeResponseDto dto = bikeService.find(bikeId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}