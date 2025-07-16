package com.bit.backend.services.impl;

import com.bit.backend.dtos.CommonDataDto;
import com.bit.backend.dtos.CommonDataListDto;
import com.bit.backend.entities.CommonDataEntity;
import com.bit.backend.entities.PrivilegeGroupAuth;
import com.bit.backend.entities.PrivilegeGroupUser;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CommonDataMapper;
import com.bit.backend.repositories.*;
import com.bit.backend.services.CommonDataServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonDataService implements CommonDataServiceI {

    private final CommonDataRepository commonDataRepository;
    private final CommonDataMapper commonDataMapper;
    private final PrivilegeGroupAuthRepository privilegeGroupAuthRepository;
    private final PrivilegeGroupUserRepository privilegeGroupUserRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderItemDetailsRepository orderItemDetailsRepository;

    CommonDataService(CommonDataRepository commonDataRepository,
                      CommonDataMapper commonDataMapper,
                      PrivilegeGroupAuthRepository privilegeGroupAuthRepository,
                      PrivilegeGroupUserRepository privilegeGroupUserRepository,
                      OrderDetailsRepository orderDetailsRepository, OrderItemDetailsRepository orderItemDetailsRepository) {
        this.commonDataRepository = commonDataRepository;
        this.commonDataMapper = commonDataMapper;
        this.privilegeGroupAuthRepository = privilegeGroupAuthRepository;
        this.privilegeGroupUserRepository = privilegeGroupUserRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderItemDetailsRepository = orderItemDetailsRepository;
    }

    @Override
    public List<CommonDataDto> getAvailablePrivilegesByGroupID(int id) {
        List<CommonDataEntity> commonDataEntities = this.commonDataRepository.getAvailablePrivilegesByGroupId(id);
        List<CommonDataDto> availablePrivileges = this.commonDataMapper.toCommonDataDtoList(commonDataEntities);
        return availablePrivileges;
    }

    @Override
    public List<CommonDataDto> getAssignedPrivilegesByGroupID(int id) {
        List<CommonDataEntity> commonDataEntities = this.commonDataRepository.getAssignedPrivilegesByGroupId(id);
        List<CommonDataDto> availablePrivileges = this.commonDataMapper.toCommonDataDtoList(commonDataEntities);
        return availablePrivileges;
    }

    @Override
    public CommonDataListDto saveData(int id, CommonDataListDto commonDataListDto) {
        List<CommonDataDto> addedCommonDataDtos = commonDataListDto.getAddedData();
        List<CommonDataDto> removedCommonDataDtos = commonDataListDto.getRemovedData();

        for (CommonDataDto commonDataDto: removedCommonDataDtos) {

            int authGroupId = id;
            int authId = commonDataDto.getId().intValue();

            PrivilegeGroupAuth privilegeGroupAuth = this.privilegeGroupAuthRepository.
                                                    findByAuthGroupIdAndAuthId(authGroupId, authId);

            this.privilegeGroupAuthRepository.delete(privilegeGroupAuth);

        }

        for (CommonDataDto commonDataDto: addedCommonDataDtos) {

            PrivilegeGroupAuth privilegeGroupAuth = new PrivilegeGroupAuth();
            privilegeGroupAuth.setAuthGroupId(id);
            privilegeGroupAuth.setAuthId(commonDataDto.getId().intValue());

            this.privilegeGroupAuthRepository.save(privilegeGroupAuth);

        }
        return commonDataListDto;
    }

    @Override
    public List<CommonDataDto> getAvailableUsersByGroupID(int id) {
        List<CommonDataEntity> commonDataEntities = this.commonDataRepository.getAvailableUsersByGroupID(id);
        List<CommonDataDto> availableUsers = this.commonDataMapper.toCommonDataDtoList(commonDataEntities);
        return availableUsers;
    }

    @Override
    public List<CommonDataDto> getAssignedUsersByGroupID(int id) {
        List<CommonDataEntity> commonDataEntities = this.commonDataRepository.getAssignedUsersByGroupId(id);
        List<CommonDataDto> availablePrivileges = this.commonDataMapper.toCommonDataDtoList(commonDataEntities);
        return availablePrivileges;
    }

    @Override
    public CommonDataListDto saveGroupUserData(int id, CommonDataListDto commonDataListDto) {
        List<CommonDataDto> addedCommonDataDtos = commonDataListDto.getAddedData();
        List<CommonDataDto> removedCommonDataDtos = commonDataListDto.getRemovedData();

        for (CommonDataDto commonDataDto: removedCommonDataDtos) {

            int authGroupId = id;
            int userId = commonDataDto.getId().intValue();

            PrivilegeGroupUser privilegeGroupUser = this.privilegeGroupUserRepository.
                    findByAuthGroupIdAndUserId(authGroupId, userId);

            this.privilegeGroupUserRepository.delete(privilegeGroupUser);

        }

        for (CommonDataDto commonDataDto: addedCommonDataDtos) {

            PrivilegeGroupUser privilegeGroupUser = new PrivilegeGroupUser();
            privilegeGroupUser.setAuthGroupId(id);
            privilegeGroupUser.setUserId(commonDataDto.getId().intValue());

            this.privilegeGroupUserRepository.save(privilegeGroupUser);

        }
        return commonDataListDto;
    }

    @Override
    public List<Map<String, Object>> getMonthlySales() {
        try {
            return orderDetailsRepository.getMonthlySales();
        } catch (Exception e) {
            throw new AppException("Request failed with error while getting data to stat charts: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Map<String, Object>> getMonthlySalesIncome() {
        try {
            return orderDetailsRepository.getMonthlySalesIncome();
        } catch (Exception e) {
            throw new AppException("Request failed with error while getting data to stat charts: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Map<String, Object>> getNoOfOrdersPlaceThisWeekByStatus() {
        try {
            return orderDetailsRepository.getNoOfOrdersPlaceThisWeekByStatus();
        } catch (Exception e) {
            throw new AppException("Request failed with error while getting data to stat charts: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Map<String, Object>> getSalesPerOrderItem() {
        try {
            return orderItemDetailsRepository.getSalesPerOrderItem();
        } catch (Exception e) {
            throw new AppException("Request failed with error while getting data to stat charts: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
