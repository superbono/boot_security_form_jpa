package com.form.security.service;

import com.form.security.domain.entity.UserEntity;
import com.form.security.domain.repository.UserRepository;
import com.form.security.dto.Role;
import com.form.security.dto.UserDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public Long join(UserDto dto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return repository.save(dto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> response = repository.findByUsername(username);
        UserEntity entity = response.get();
        System.out.println("Entity: "+ entity);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(("admin").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        System.out.println("ROLE: "+authorities);
        return new User(entity.getUsername(),entity.getPassword(),authorities);
    }
}
