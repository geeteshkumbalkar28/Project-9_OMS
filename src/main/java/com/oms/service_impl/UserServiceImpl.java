package com.oms.service_impl;

import com.oms.Entity.Roles;
import com.oms.Entity.Task;
import com.oms.Entity.UserRole;
import com.oms.Entity.Users;
import com.oms.dto.UserDto;
import com.oms.exceptions.*;
import com.oms.repositories.RolesRepository;
import com.oms.repositories.UsersRepository;
import com.oms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
            role.setName("ADMIN");

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

    @Override
    public UserDto getUserById(Integer userId) {
        Users users = this.usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        UserDto dto = toDTO(users);
        return dto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
         Users users = this.usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

         users.setEnabled(userDto.getEnabled());

         UserDto dto= toDTO(users);
         this.usersRepository.save(users);
         return dto;
    }

    @Override
    public List<UserDto> findAllUsers(Integer id) throws PageNotFoundException, TaskNotFoundException {
        List<Users> users = usersRepository.findAll();

        if (users.isEmpty()) {
            throw new TaskNotFoundException("No tasks found");
        }

        int pageSize = 10;
        int totalPages = (int) Math.ceil((double) users.size() / pageSize);

        if (id >= totalPages) {
            throw new PageNotFoundException("Page not found");
        }

        int start = id * pageSize;
        int end = Math.min((id + 1) * pageSize, users.size());

        List<UserDto> listOfUsersDto = new ArrayList<>();

        for (int i = start; i < end; i++) {
            UserDto dto = toDTO(users.get(i));
            dto.setUser_id(users.get(i).getUser_id());
            listOfUsersDto.add(dto);
        }

        return listOfUsersDto;

    }

    @Override
    public void deleteUserById(Integer userId) {
        Users user=this.usersRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        try {
            usersRepository.deleteById(userId);
        } catch (Exception e) {
        }
    }


    public UserDto toDTO(Users users) {
        UserDto dto = new UserDto();
        dto.setUser_id(users.getUser_id());
        dto.setEmail(users.getEmail());
        dto.setFullName(users.getFullName());
        dto.setGender(users.getGender());
        dto.setMoNumber(users.getMoNumber());
        dto.setPassword(users.getPassword());
        dto.setRef(users.getRef());
        dto.setStatus(users.getStatus());
        dto.setAuthorities(users.getAuthorities());
        dto.setEnabled(users.getEnabled());
        return dto;
    }


    public static Users fromDTO(UserDto dto) {
        Users entity = new Users();
        entity.setUser_id(dto.getUser_id());
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
