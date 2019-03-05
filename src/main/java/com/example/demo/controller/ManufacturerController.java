package com.example.demo.controller;

import com.example.demo.dto.ManufacturerCreateDto;
import com.example.demo.dto.ManufacturerResponseDto;
import com.example.demo.service.ManufacturerService;
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

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Inject
    public ManufacturerController(final ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody final ManufacturerCreateDto dto) {
        manufacturerService.add(dto);
    }

    @GetMapping("/{manufacturerId}")
    public ResponseEntity<ManufacturerResponseDto> findById(@PathVariable final long manufacturerId) {
        return new ResponseEntity<>(manufacturerService.find(manufacturerId), HttpStatus.OK);
    }
}