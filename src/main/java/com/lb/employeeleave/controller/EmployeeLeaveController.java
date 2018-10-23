package com.lb.employeeleave.controller;

import com.lb.employeeleave.dto.LeaveDTO;
import com.lb.employeeleave.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/employee-leaves")
public class EmployeeLeaveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeLeaveController.class);

    private final LeaveService employeeLeaveService;

    public EmployeeLeaveController(final LeaveService employeeLeaveService) {
        this.employeeLeaveService = employeeLeaveService;
    }

    /**
     * Retrieve all Employees
     * Http Get Method must be specified.
     * Url must be set on - server-url/base-path/employee-leaves
     * The data is returned in JSON format
     *
     * @param pageable
     * @return List of Leave in JSON format
     */
    @GetMapping
    public ResponseEntity<?> retrieveAllEmployeeLeaves(@PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable){

        LOGGER.info("API Retrieve all EmployeeLeaves");
        return new ResponseEntity<>(employeeLeaveService.getAllEmployeeLeaves(pageable), HttpStatus.OK);
    }

    /**
     * Retrieve single Leave
     * Http Get Method must be specified
     * Url must be set on - server-url/base-path/employee-leave/{id}
     *
     * @param id of Leave that we want to retrieve
     * @return Single Employee in JSON format
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveEmployeeLeave(@PathVariable long id){

        LOGGER.info("API Retrieve single Leave");
        return new ResponseEntity<>(employeeLeaveService.getEmployeeLeaveById(id), HttpStatus.OK);
    }

    /**
     * Create Leave
     * Http Post method must be specified
     * Url must be set on - server-url/base-path/employee-leave
     * The data is returned in JSON format
     *
     * @param employeeLeaveDTO json data specifying Leave request to add
     * @return Created Leave in JSON format
     */
    @PostMapping
    public ResponseEntity<?> createEmployeeLeave(@RequestBody LeaveDTO employeeLeaveDTO){

        LOGGER.info("API Create Leave Request");
        return new ResponseEntity<>(employeeLeaveService.createEmployeeLeave(employeeLeaveDTO), HttpStatus.OK);
    }

    /**
     * Update Leave
     * Http put method must be specified
     * Url must be set on - server-url/base-path/employee-leave/{id}
     *
     * @param employeeLeaveDTO JSON data specifying Leave to update
     * @return Updated Leave in JSON format
     */
    @PutMapping
    public ResponseEntity<?> updateEmployeeLeave(@RequestBody LeaveDTO employeeLeaveDTO){

        LOGGER.info("API update Leave");
        return new ResponseEntity<>(employeeLeaveService.updateEmployeeLeave(employeeLeaveDTO), HttpStatus.OK);
    }

    /**
     * Approve Leave
     * Http Put method must be specified
     * Url must be set on - server-url/base-path/approve-employee-leave
     *
     * @param employeeLeaveDTO JSON data specifying Leave to approve
     * @return Approved Leave in JSON format
     */
    @PutMapping("/approve-employee-leave")
    public ResponseEntity<?> approveEmployeeLeave(@RequestBody LeaveDTO employeeLeaveDTO){

        LOGGER.info("API Approve Leave");
        return new ResponseEntity<>(employeeLeaveService.approveEmployeeLeave(employeeLeaveDTO), HttpStatus.OK);
    }

    /**
     * Delete Pending Leave Request
     * Http Put method must be specified
     * Url must be set on - server-url/base-path/delete-pending-request/{id}
     *
     * @param id specifying Leave to delete
     * @return Boolean status of Leave deletion
     */
    @DeleteMapping("/change-request-status/{id}")
    public ResponseEntity<?> ChangeEmployeeLeaveStatus(@PathVariable long id){

        LOGGER.info("API Delete Pending Leave Request");
        return new ResponseEntity<>(employeeLeaveService.ChangeEmployeeLeaveStatus(id), HttpStatus.OK);
    }
}
