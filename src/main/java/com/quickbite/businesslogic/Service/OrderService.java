package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Order.OrderCreateDTO;
import com.quickbite.businesslogic.Dto.Order.OrderDTO;
import com.quickbite.businesslogic.Dto.Order.OrderDTOMapper;
import com.quickbite.businesslogic.Entities.Order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDTOMapper orderDTOMapper;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderDTOMapper)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrder(Long id) {
        return orderRepository.findById(id)
                .map(orderDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Order not found!"));
    }

    public void createOrder(OrderCreateDTO orderCreateDTO) {
    }

    public void updateOrder(Long id, OrderCreateDTO orderCreateDTO) {
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
