package com.gmail.eugene.travelbot.service.conveter.impl;

import com.gmail.eugene.travelbot.repository.model.City;
import com.gmail.eugene.travelbot.service.conveter.CityConverter;
import com.gmail.eugene.travelbot.service.model.CityDTO;
import org.springframework.stereotype.Component;

@Component
public class CityConverterImpl implements CityConverter {
    @Override
    public CityDTO toDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setInfo(city.getInfo());
        return cityDTO;
    }
}
