package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Order.OrderCreateDTO;
import com.quickbite.businesslogic.Dto.Order.OrderDTO;
import com.quickbite.businesslogic.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok( orderService.getAllOrders() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok( orderService.getOrder(id) );
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        orderService.createOrder(orderCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody OrderCreateDTO orderCreateDTO) {
        orderService.updateOrder(id, orderCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Success!");
    }
}
