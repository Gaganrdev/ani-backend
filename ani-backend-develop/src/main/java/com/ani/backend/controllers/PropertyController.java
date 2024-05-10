package com.ani.backend.controllers;

import com.ani.backend.dao.Property;
import com.ani.backend.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

  

    @GetMapping("/Property/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> propertyObj = propertyRepository.findById(id);
        if (propertyObj.isPresent()) {
            return new ResponseEntity<>(propertyObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Property")
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        try {
            Property propertyObj = propertyRepository.save(property);
            return new ResponseEntity<>(propertyObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Property/{id}")
    public ResponseEntity<Property> updatePeoperty(@PathVariable Long id, @RequestBody Property property) {
        try {
            Optional<Property> propertyData = propertyRepository.findById(id);
            if (propertyData.isPresent()) {
                Property updatedPropertyData = propertyData.get();
                updatedPropertyData.setAmenities(property.getAmenities());
                updatedPropertyData.setBalcony(property.getBalcony());
                updatedPropertyData.setBathrooms(property.getBathrooms());
                updatedPropertyData.setBedrooms(property.getBedrooms());
                updatedPropertyData.setDescription(property.getDescription());
                updatedPropertyData.setFlatNo(property.getFlatNo());
                updatedPropertyData.setKitchen(property.getKitchen());
                updatedPropertyData.setPropertyType(property.getPropertyType());
                updatedPropertyData.setTitle(property.getTitle());
                updatedPropertyData.setBuildingId(property.getBuildingId());
                updatedPropertyData.setMaxguestAllowes(property.getMaxguestAllowes());

Property propertyObj = propertyRepository.save(updatedPropertyData);
                return new ResponseEntity<>(propertyObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Property/{id}")
    public ResponseEntity<Property> deletePropertyById(@PathVariable Long id) {
        Optional<Property> propertyObj = propertyRepository.findById(id);
        if (propertyObj.isPresent()) {
            propertyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

