package com.bit.backend.services;

import com.bit.backend.dtos.*;

import java.util.List;

public interface UserServiceI {
    UserDto login(CredentialsDto credentialsDto) throws Exception;
    UserDto register(SignUpDto signUpDto);
    List<Integer> getAuthIds(long userId);
    SystemPrivilegeListDto getSystemPrivileges();
    List<Integer> setSystemPrivileges(SystemPrivilegeListDto systemPrivilegeListDto);
    boolean updateUser(SignUpDto signUpDto, Long userId);
    boolean checkIfUserNameExist(String login);
    boolean checkIfUserNameExistForOtherUsers(String userName, long id);
}
