
package com.real.estate.service;

import com.real.estate.entity.Property;
import java.util.List;

public interface PropertyService {
    Property addProperty(Property property);
    Property getPropertyById(long id);
    List<Property> getAllProperties();
    void deletePropertyById(long id);
}
