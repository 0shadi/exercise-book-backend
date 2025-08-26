package com.bit.backend.controllers;

import com.bit.backend.dtos.CommonDataDto;
import com.bit.backend.dtos.CommonDataListDto;
import com.bit.backend.entities.CommonDataEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CommonDataServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common-data-service")
public class CommonServiceController {

    private final CommonDataServiceI commonDataServiceI;

    public CommonServiceController(CommonDataServiceI commonDataServiceI) {
        this.commonDataServiceI = commonDataServiceI;
    }

    @GetMapping("/available-privileges/{id}")
    public List<CommonDataDto> getAvailablePrivilegesByGroupID(@PathVariable int id) {
        List<CommonDataDto> availablePrivileges = commonDataServiceI.getAvailablePrivilegesByGroupID(id);
        return availablePrivileges;
    }

    @GetMapping("/assigned-privileges/{id}")
    public List<CommonDataDto> getAssignedPrivilegesByGroupID(@PathVariable int id) {
        List<CommonDataDto> availablePrivileges = commonDataServiceI.getAssignedPrivilegesByGroupID(id);
        return availablePrivileges;
    }

    @PostMapping("/group-privileges/{id}")
    public CommonDataListDto saveData(@RequestBody CommonDataListDto commonDataListDto, @PathVariable int id) {
        CommonDataListDto savedData = commonDataServiceI.saveData(id, commonDataListDto);
        return savedData;
    }

    @GetMapping("/group-available-users/{id}")
    public List<CommonDataDto> getAvailableUsersByGroupID(@PathVariable int id) {
        List<CommonDataDto> availablePrivileges = commonDataServiceI.getAvailableUsersByGroupID(id);
        return availablePrivileges;
    }

    @GetMapping("/group-assigned-users/{id}")
    public List<CommonDataDto> getAssignedUsersByGroupID(@PathVariable int id) {
        List<CommonDataDto> availablePrivileges = commonDataServiceI.getAssignedUsersByGroupID(id);
        return availablePrivileges;
    }

    @PostMapping("/privilege-group-users/{id}")
    public CommonDataListDto saveGroupUserData(@RequestBody CommonDataListDto commonDataListDto, @PathVariable int id) {
        CommonDataListDto savedData = commonDataServiceI.saveGroupUserData(id, commonDataListDto);
        return savedData;
    }

    @GetMapping("/monthly-sales")
    public ResponseEntity<List<Map<String, Object>>> getMonthlySales() {
        try {
            List<Map<String, Object>> commonTaskStats = commonDataServiceI.getMonthlySales();
            return ResponseEntity.ok(commonTaskStats);
        } catch (Exception e) {
            throw new AppException("Request Fail With Error:"+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/monthly-sales-income")
    public ResponseEntity<List<Map<String, Object>>> getMonthlySalesIncome() {
        try {
            List<Map<String, Object>> commonTaskStats = commonDataServiceI.getMonthlySalesIncome();
            return ResponseEntity.ok(commonTaskStats);
        } catch (Exception e) {
            throw new AppException("Request Fail With Error:"+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/wekly-orders-by-status")
    public ResponseEntity<List<Map<String, Object>>> getNoOfOrdersPlaceThisWeekByStatus() {
        try {
            List<Map<String, Object>> commonTaskStats = commonDataServiceI.getNoOfOrdersPlaceThisWeekByStatus();
            return ResponseEntity.ok(commonTaskStats);
        } catch (Exception e) {
            throw new AppException("Request Fail With Error:"+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sales-per-item")
    public ResponseEntity<List<Map<String, Object>>> getSalesPerOrderItem() {
        try {
            List<Map<String, Object>> commonTaskStats = commonDataServiceI.getSalesPerOrderItem();
            return ResponseEntity.ok(commonTaskStats);
        } catch (Exception e) {
            throw new AppException("Request Fail With Error:"+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
