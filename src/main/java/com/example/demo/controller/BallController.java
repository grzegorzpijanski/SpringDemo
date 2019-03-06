package com.example.demo.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.UUID;

import com.example.demo.dto.BallCreateDto;
import com.example.demo.dto.BallResponseDto;
import com.example.demo.service.BallService;
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
@RequestMapping("/balls")
public class BallController {

    private final BallService ballService;

    @Inject
    public BallController(final BallService ballService) {
        this.ballService = ballService;
    }

    @ApiOperation("Allows to add a ball")
    @PostMapping
    public ResponseEntity<UUID> add(@Valid @RequestBody final BallCreateDto dto) {
        final UUID ballId = ballService.add(dto);

        return new ResponseEntity<>(ballId, HttpStatus.OK);
    }

    @ApiOperation("Allows to find a ball by id")
    @GetMapping("/{ballId}")
    public ResponseEntity<BallResponseDto> find(@PathVariable final UUID ballId) {
        final BallResponseDto dto = ballService.find(ballId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}