package com.hotel.service;
import com.hotel.model.User;
import com.hotel.model.Role;
import com.hotel.repository.UserRepository;
import com.hotel.dto.RegisterRequest;
import com.hotel.dto.LoginRequest;
import com.hotel.dto.LoginResponse;
import com.hotel.exception.UserNotFoundException;
import com.hotel.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public User register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already registered.");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(Role.GUEST);

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        userRepository.findByEmail(request.get)
    }

}
