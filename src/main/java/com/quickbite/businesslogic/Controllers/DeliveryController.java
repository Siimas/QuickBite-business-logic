package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryCreateDTO;
import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Service.DeliveryService;
import com.quickbite.businesslogic.Service.DeliverymanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveries() {
        return ResponseEntity.ok( deliveryService.getAllDelivery() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryDTO> getDelivery(@PathVariable Long id) {
        return ResponseEntity.ok( deliveryService.getDelivery(id) );
    }

    @PostMapping
    public ResponseEntity<String> createDelivery(@RequestBody DeliveryCreateDTO deliveryCreateDTO) {
        deliveryService.createDelivery(deliveryCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateDelivery(@PathVariable Long id, @RequestBody DeliveryCreateDTO deliveryCreateDTO) {
        deliveryService.updateDelivery(id, deliveryCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> updateDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.ok("Success!");
    }
}
