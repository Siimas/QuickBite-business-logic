package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanCreateDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Service.DeliverymanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/deliveryman")
public class DeliverymanController {

    private final DeliverymanService deliverymanService;

    @GetMapping
    public ResponseEntity<List<DeliverymanDTO>> getAllDeliveryman() {
        return ResponseEntity.ok( deliverymanService.getAllDeliveryman() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliverymanDTO> getDeliveryman(@PathVariable Long id) {
        return ResponseEntity.ok( deliverymanService.getDeliveryman(id) );
    }

    @PostMapping
    public ResponseEntity<String> createDeliveryman(@RequestBody DeliverymanCreateDTO deliverymanCreateDTO) {
        deliverymanService.createDeliveryman(deliverymanCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateDeliveryman(@PathVariable Long id, @RequestBody DeliverymanCreateDTO deliverymanCreateDTO) {
        deliverymanService.updateDeliveryman(id, deliverymanCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> updateDeliveryman(@PathVariable Long id) {
        deliverymanService.deleteDeliveryman(id);
        return ResponseEntity.ok("Success!");
    }
}
