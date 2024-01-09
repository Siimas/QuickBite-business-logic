package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Staff.StaffCreateDTO;
import com.quickbite.businesslogic.Dto.Staff.StaffDTO;
import com.quickbite.businesslogic.Dto.Staff.StaffDTOMapper;
import com.quickbite.businesslogic.Entities.Staff.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;
    private final StaffDTOMapper staffDTOMapper;

    public List<StaffDTO> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(staffDTOMapper)
                .collect(Collectors.toList());
    }

    public StaffDTO getStaff(Long id) {
        return staffRepository.findById(id)
                .map(staffDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Staff not found!"));
    }

    public void createStaff(StaffCreateDTO staffCreateDTO) {
    }

    public void updateStaff(Long id, StaffCreateDTO staffCreateDTO) {
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
