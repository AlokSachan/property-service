package com.wipro.service;

import com.wipro.entity.PropertyEntity;

import java.util.List;

public interface PropertyService {
    PropertyEntity newBooking(PropertyEntity propertyEntity);

    List<PropertyEntity> getAllProperty();

    PropertyEntity getBookingDetails(Integer id);

    void deleteProperty(Integer id);

    PropertyEntity updateProperty(PropertyEntity propertyEntity);

    PropertyEntity getPropertyDetailsByTitle(String title);

    List<PropertyEntity> getPropertyDetailsByLocation(String location);

    List<PropertyEntity> getPropertyDetailsByType(String type);

    List<PropertyEntity> getPropertyDetailsByPrice(Double price);
}
