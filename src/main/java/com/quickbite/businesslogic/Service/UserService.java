package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.User.UserDTO;
import com.quickbite.businesslogic.Entities.User.UserRepository;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Long id) {
        return userRepository.findById(id)
                .map(userDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("User not found!"));
    }
}
