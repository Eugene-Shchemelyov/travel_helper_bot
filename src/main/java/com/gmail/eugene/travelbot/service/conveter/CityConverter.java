package com.gmail.eugene.travelbot.service.conveter;

import com.gmail.eugene.travelbot.repository.model.City;
import com.gmail.eugene.travelbot.service.model.CityDTO;

public interface CityConverter {
    CityDTO toDTO(City city);
}
