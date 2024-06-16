package com.wipro.repository;

import com.wipro.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer> {
    PropertyEntity findByTitle(String title);

    List<PropertyEntity> findByLocation(String location);

    List<PropertyEntity> findByType(String type);

    List<PropertyEntity> findByPrice(Double price);
}
