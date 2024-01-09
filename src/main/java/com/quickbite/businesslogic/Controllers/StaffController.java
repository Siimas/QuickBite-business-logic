package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Staff.StaffCreateDTO;
import com.quickbite.businesslogic.Dto.Staff.StaffDTO;
import com.quickbite.businesslogic.Service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        return ResponseEntity.ok( staffService.getAllStaff() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StaffDTO> getStaff(@PathVariable Long id) {
        return ResponseEntity.ok( staffService.getStaff(id) );
    }

    @PostMapping
    public ResponseEntity<String> createStaff(@RequestBody StaffCreateDTO staffCreateDTO) {
        staffService.createStaff(staffCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id, @RequestBody StaffCreateDTO staffCreateDTO) {
        staffService.updateStaff(id, staffCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Success!");
    }
}
