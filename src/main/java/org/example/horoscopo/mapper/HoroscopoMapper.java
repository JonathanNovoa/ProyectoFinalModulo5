package org.example.horoscopo.mapper;

import org.example.horoscopo.dto.HoroscopoCreateDto;
import org.example.horoscopo.dto.HoroscopoRespondeDto;
import org.example.horoscopo.model.Horoscopo;

public class HoroscopoMapper {
    public static HoroscopoRespondeDto toEntity(Horoscopo horoscopo) {
        return new HoroscopoRespondeDto(horoscopo.getId(), horoscopo.getAnimal());
    }

    public static HoroscopoCreateDto toDto(Horoscopo horoscopo) {
        return new HoroscopoCreateDto(horoscopo.getId(), horoscopo.getAnimal(), horoscopo.getFechaInicio(), horoscopo.getFechaFinal());
    }
}
