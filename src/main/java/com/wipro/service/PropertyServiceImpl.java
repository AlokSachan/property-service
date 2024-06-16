package com.wipro.service;

import com.wipro.entity.PropertyEntity;
import com.wipro.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyEntity newBooking(PropertyEntity propertyEntity) {
        return propertyRepository.save(propertyEntity);
    }

    @Override
    public List<PropertyEntity> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public PropertyEntity getBookingDetails(Integer id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public void deleteProperty(Integer id) {
        PropertyEntity bookingDetails = getBookingDetails(id);
        propertyRepository.delete(bookingDetails);
    }

    @Override
    public PropertyEntity updateProperty(PropertyEntity propertyEntity) {
        return propertyRepository.save(propertyEntity);
    }

    @Override
    public PropertyEntity getPropertyDetailsByTitle(String title) {
        return propertyRepository.findByTitle(title);
    }

    @Override
    public List<PropertyEntity> getPropertyDetailsByLocation(String location) {
        return propertyRepository.findByLocation(location);
    }

    @Override
    public List<PropertyEntity> getPropertyDetailsByType(String type) {
        return propertyRepository.findByType(type);
    }

    @Override
    public List<PropertyEntity> getPropertyDetailsByPrice(Double price) {
        return propertyRepository.findByPrice(price);
    }
}
