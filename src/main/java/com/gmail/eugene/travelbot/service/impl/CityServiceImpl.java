package com.gmail.eugene.travelbot.service.impl;

import com.gmail.eugene.travelbot.repository.CityRepository;
import com.gmail.eugene.travelbot.repository.model.City;
import com.gmail.eugene.travelbot.service.CityService;
import com.gmail.eugene.travelbot.service.conveter.CityConverter;
import com.gmail.eugene.travelbot.service.model.CityDTO;
import com.gmail.eugene.travelbot.service.model.NewCityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    @Autowired
    public CityServiceImpl(
            CityRepository cityRepository,
            CityConverter cityConverter
    ) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    @Override
    @Transactional
    public String getInfo(String text) {
        City city = cityRepository.getByName(text);
        if (city != null) {
            return city.getInfo();
        }
        return String.format("Sorry. This city didn't supported: %s.", text);
    }

    @Override
    @Transactional
    public List<CityDTO> getCities() {
        List<City> cities = cityRepository.getAllEntities();
        return cities.stream()
                .map(cityConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CityDTO getById(Long id) {
        City city = cityRepository.getById(id);
        return cityConverter.toDTO(city);
    }

    @Override
    @Transactional
    public CityDTO add(NewCityDTO newCityDTO) {
        City city = new City();
        city.setName(newCityDTO.getName());
        city.setInfo(newCityDTO.getInfo());
        cityRepository.create(city);
        City addedCity = cityRepository.getByName(newCityDTO.getName());
        return cityConverter.toDTO(addedCity);
    }

    @Override
    @Transactional
    public CityDTO update(CityDTO cityDTO) {
        City city = cityRepository.getById(cityDTO.getId());
        if (cityDTO.getName() != null && !cityDTO.getName().isEmpty()) {
            city.setName(cityDTO.getName());
        }
        if (cityDTO.getInfo() != null && !cityDTO.getInfo().isEmpty()) {
            city.setInfo(cityDTO.getInfo());
        }
        cityRepository.update(city);
        return cityConverter.toDTO(city);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
