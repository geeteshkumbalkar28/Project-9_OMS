package com.oms.service_impl;

import com.oms.Entity.Roles;
import com.oms.Entity.UserRole;
import com.oms.Entity.Users;
import com.oms.dto.UserDto;
import com.oms.exceptions.UserAlreadyExistException;
import com.oms.repositories.RolesRepository;
import com.oms.repositories.UsersRepository;
import com.oms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDto createUser(UserDto userDTO) throws Exception {

        Users existingUser = usersRepository.findByEmail(userDTO.getEmail());


        if (existingUser != null) {
            System.out.println("User already exists");
            throw new UserAlreadyExistException("User already exists");
        } else {

            Users user = fromDTO(userDTO);

            Set<UserRole> roles = new HashSet<>();
            Roles role = new Roles();
            role.setId(45);
            role.setName("NORMAL");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            roles.add(userRole);


            for (UserRole ur : roles) {
                this.rolesRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(roles);
            user.setDate(LocalDate.now());

            Users registeredUser = usersRepository.save(user);


            return toDTO(registeredUser);
        }
    }

    public UserDto toDTO(Users users) {
        UserDto dto = new UserDto();

        dto.setEmail(users.getEmail());
        dto.setFullName(users.getFullName());
        dto.setGender(users.getGender());
        dto.setMoNumber(users.getMoNumber());
        dto.setPassword(users.getPassword());
        dto.setRef(users.getRef());
        dto.setStatus(users.getStatus());

        return dto;
    }


    public static Users fromDTO(UserDto dto) {
        Users entity = new Users();

        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setGender(dto.getGender());
        entity.setMoNumber(dto.getMoNumber());
        entity.setPassword(dto.getPassword());
        entity.setRef(dto.getRef());
        entity.setStatus(dto.getStatus());

        return entity;
    }

}
