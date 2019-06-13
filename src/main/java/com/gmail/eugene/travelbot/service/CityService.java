package com.gmail.eugene.travelbot.service;

import com.gmail.eugene.travelbot.service.model.CityDTO;
import com.gmail.eugene.travelbot.service.model.NewCityDTO;

import java.util.List;

public interface CityService {
    String getInfo(String text);

    List<CityDTO> getCities();

    CityDTO getById(Long id);

    CityDTO add(NewCityDTO newCityDTO);

    CityDTO update(CityDTO cityDTO);

    void delete(Long id);
}
