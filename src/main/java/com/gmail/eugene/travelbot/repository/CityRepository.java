package com.gmail.eugene.travelbot.repository;

import com.gmail.eugene.travelbot.repository.model.City;

public interface CityRepository extends GenericRepository<Long, City>{
    City getByName(String text);
}
