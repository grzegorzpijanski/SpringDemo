package com.example.demo.service;

import com.example.demo.BaseUnitTest;
import com.example.demo.dto.ManufacturerCreateDto;
import com.example.demo.dto.ManufacturerResponseDto;
import com.example.demo.mapper.ManufacturerMapper;
import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.UUID;

class ManufacturerServiceTest extends BaseUnitTest {

    @InjectMocks
    private ManufacturerService manufacturerService;

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @Mock
    private ManufacturerMapper manufacturerMapper;

    @Nested
    class Create {

        @Test
        void shouldCreateBike() {
            // given
            final Manufacturer manufacturer = randomManufacturer();
            final ManufacturerCreateDto dto = new ManufacturerCreateDto(manufacturer.getName(), manufacturer.getAddress());

            // when
            when(manufacturerMapper.toDomain(dto)).thenReturn(manufacturer);
            when(manufacturerRepository.save(manufacturer)).thenReturn(manufacturer);

            final UUID response = manufacturerService.create(dto);

            // then
            assertThat(response).isEqualTo(manufacturer.getId());
        }
    }

    @Nested
    class Find {

        @Test
        void shouldFindBikeById() {
            // given
            final UUID manufacturerId = randomUUID();
            final Manufacturer manufacturer = randomManufacturer(manufacturerId);
            final ManufacturerResponseDto dto = toDto(manufacturer);

            // when
            when(manufacturerRepository.findById(manufacturerId)).thenReturn(Optional.of(manufacturer));
            when(manufacturerMapper.toResponseDto(manufacturer)).thenReturn(dto);

            final ManufacturerResponseDto response = manufacturerService.find(manufacturerId);

            // then
            assertThat(response).isEqualTo(dto);
        }
    }

    private ManufacturerResponseDto toDto(final Manufacturer manufacturer) {
        return new ManufacturerResponseDto(manufacturer.getId(), manufacturer.getName(), manufacturer.getAddress());
    }
}