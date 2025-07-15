package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.User;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.UserMapper;
import com.bit.backend.repositories.UserRepository;
import com.bit.backend.services.UserServiceI;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto login(CredentialsDto credentialsDto) {
        logger.debug("Entering in login Method...");
        User user = userRepository.findByLogin(credentialsDto.login()).orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto register(SignUpDto signUpDto) {
        Optional<User> oUser = userRepository.findByLogin(signUpDto.login());

        if (oUser.isPresent()) {
            throw new AppException("User Already Exists", HttpStatus.BAD_REQUEST);
        }
        User user = userMapper.signUpToUser(signUpDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public List<Integer> getAuthIds(long userId) {
        Optional<List<Integer>> optionalAuthIdLists = userRepository.findAuthIdsByUserId(userId);
        List<Integer> authIdLists = optionalAuthIdLists.get();

        return authIdLists;
    }

    @Override
    public SystemPrivilegeListDto getSystemPrivileges() {
        List<Tuple> tupleAvailableSystemPrivilegeLists = userRepository.getAvailableSystemPrivileges();
        List<Tuple> tupleAssignedSystemPrivilegeLists = userRepository.getAssignedSystemPrivileges();
        SystemPrivilegeListDto systemPrivilegeListDto = new SystemPrivilegeListDto();

        List<SystemPrivilegeDto> availableSystemPrivilegeLists = tupleAvailableSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        List<SystemPrivilegeDto> assignSystemPrivilegeLists = tupleAssignedSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        systemPrivilegeListDto.setSourcePrivileges(availableSystemPrivilegeLists);
        systemPrivilegeListDto.setTargetPrivileges(assignSystemPrivilegeLists);

        return systemPrivilegeListDto;
    }

    @Override
    public List<Integer> setSystemPrivileges(SystemPrivilegeListDto systemPrivilegeListDto) {

        return null;
    }

    @Override
    public boolean updateUser(SignUpDto signUpDto, Long userId) {
        return this.updateUserProcess(signUpDto, userId);
    }

    @Override
    public boolean checkIfUserNameExist(String login) {
        Optional<User> user = userRepository.findByLogin(login);

        if (user.isPresent()) {
            return true;
        }
        return false;
    }

    public boolean updateUserProcess(SignUpDto signUpDto, Long userId) {
        User user = userRepository.findById(
                userId).orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
        try {
            user.setFirstName(signUpDto.firstName());
            user.setLastName(signUpDto.lastName());
            user.setLogin(signUpDto.login());

            if (user.getRole().equals("EMPLOYEE")) {
                user.setEmployeeLoginId(signUpDto.employeeLoginId());
            } else if (user.getRole().equals("CUSTOMER")) {
                user.setCustomerLoginId(signUpDto.customerLoginId());
            }


            if (signUpDto.password().length > 0) {
                if (!passwordEncoder.matches(CharBuffer.wrap(signUpDto.password()), user.getPassword())) {
                    user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
                }
            }
            userRepository.save(user);
            return true;
        } catch(Exception e) {
            throw new AppException("Error occurred! Please try again", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean checkIfUserNameExistForOtherUsers(String userName) {
        try {

            List<User> userList = userRepository.checkIfUserNameExistForOtherUsers(userName);

            if (userList.size() > 0) {
                return true;
            }

            return false;

        } catch (Exception e) {
            throw new AppException("Error occurred! Please try again", HttpStatus.BAD_REQUEST);
        }
    }
}
