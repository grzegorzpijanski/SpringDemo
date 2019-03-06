package com.example.demo.controller;

import com.example.demo.dto.ManufacturerCreateDto;
import com.example.demo.dto.ManufacturerResponseDto;
import com.example.demo.service.ManufacturerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Inject
    public ManufacturerController(final ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @ApiOperation("Allows to add a manufacturer")
    @PostMapping
    public ResponseEntity<UUID> add(@RequestBody final ManufacturerCreateDto dto) {
        final UUID manufacturerId = manufacturerService.add(dto);

        return new ResponseEntity<>(manufacturerId, HttpStatus.OK);
    }

    @ApiOperation("Allows to find a manufacturer by id")
    @GetMapping("/{manufacturerId}")
    public ResponseEntity<ManufacturerResponseDto> findById(@PathVariable final UUID manufacturerId) {
        final ManufacturerResponseDto dto = manufacturerService.find(manufacturerId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}