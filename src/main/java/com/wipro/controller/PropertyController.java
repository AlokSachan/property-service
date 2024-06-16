package com.wipro.controller;

import com.wipro.entity.PropertyEntity;
import com.wipro.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyEntity> newProperty(@RequestBody PropertyEntity propertyEntity) {
        return new ResponseEntity<PropertyEntity>(propertyService.newBooking(propertyEntity), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropertyEntity>> getAllProperty() {
        return new ResponseEntity<>(propertyService.getAllProperty(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyEntity> getPropertyDetails(@PathVariable Integer id) {
        return new ResponseEntity<PropertyEntity>(propertyService.getBookingDetails(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyEntity> updateProperty(@RequestBody PropertyEntity propertyEntity) {
        return new ResponseEntity<>(propertyService.updateProperty(propertyEntity), HttpStatus.CREATED);
    }

    @GetMapping(value = "/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyEntity> getPropertyDetailsByTitle(@PathVariable String title) {
        return new ResponseEntity<PropertyEntity>(propertyService.getPropertyDetailsByTitle(title), HttpStatus.OK);
    }

    @GetMapping(value = "/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropertyEntity>> getPropertyDetailsByLocation(@PathVariable String location) {
        return new ResponseEntity<>(propertyService.getPropertyDetailsByLocation(location), HttpStatus.OK);
    }

    @GetMapping(value = "/type/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropertyEntity>> getPropertyDetailsByType(@PathVariable String type) {
        return new ResponseEntity<>(propertyService.getPropertyDetailsByType(type), HttpStatus.OK);
    }

    @GetMapping(value = "/type/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropertyEntity>> getPropertyDetailsByPrice(@PathVariable Double price) {
        return new ResponseEntity<>(propertyService.getPropertyDetailsByPrice(price), HttpStatus.OK);
    }
}
