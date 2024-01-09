package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Payment.PaymentCreateDTO;
import com.quickbite.businesslogic.Dto.Payment.PaymentDTO;
import com.quickbite.businesslogic.Service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        return ResponseEntity.ok( paymentService.getAllPayments() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok( paymentService.getPayment(id) );
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody PaymentCreateDTO paymentCreateDTO) {
        paymentService.createPayment(paymentCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody PaymentCreateDTO paymentCreateDTO) {
        paymentService.updatePayment(id, paymentCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Success!");
    }
}
