package com.quickbite.businesslogic.Dto.Staff;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import com.quickbite.businesslogic.Entities.Staff.Staff;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class StaffDTOMapper implements Function<Staff, StaffDTO> {

    private final RestaurantDTOMapper restaurantDTOMapper;
    private final UserDTOMapper userDTOMapper;

    @Override
    public StaffDTO apply(Staff staff) {
        return new StaffDTO(
                staff.getId(),
                restaurantDTOMapper.apply(staff.getRestaurant()),
                userDTOMapper.apply(staff.getUser())
        );
    }
}
