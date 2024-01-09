package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Payment.PaymentCreateDTO;
import com.quickbite.businesslogic.Dto.Payment.PaymentDTO;
import com.quickbite.businesslogic.Dto.Payment.PaymentDTOMapper;
import com.quickbite.businesslogic.Entities.Payment.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentDTOMapper paymentDTOMapper;

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentDTOMapper)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPayment(Long id) {
        return paymentRepository.findById(id)
                .map(paymentDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Payment not found!"));
    }

    public void createPayment(PaymentCreateDTO paymentCreateDTO) {
    }

    public void updatePayment(Long id, PaymentCreateDTO paymentCreateDTO) {
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
