package com.gmail.eugene.travelbot.repository.impl;

import com.gmail.eugene.travelbot.repository.CityRepository;
import com.gmail.eugene.travelbot.repository.model.City;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class CityRepositoryImpl extends GenericRepositoryImpl<Long, City> implements CityRepository {
    @Override
    public City getByName(String text) {
        String query = "FROM " + entityClass.getName() +
                " WHERE name =: text";
        Query q = entityManager.createQuery(query)
                .setParameter("text", text);
        try {
            return (City) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
