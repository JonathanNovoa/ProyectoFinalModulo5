package org.example.horoscopo.repository;

import java.util.Date;

public interface HoroscopoRepository {
    String getAnimalByFechaDeNacimiento(Date Fecha);
}
