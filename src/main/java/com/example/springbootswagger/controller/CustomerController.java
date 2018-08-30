package com.example.springbootswagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootswagger.entity.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="/customer",description="Customer Profile",produces ="application/json")
@RequestMapping("/customer")
public class CustomerController {

    @ApiOperation(value="get customer",response=Customer.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Customer Details Retrieved",response=Customer.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Customer not found")
    })

    @RequestMapping(value="/getCustomer",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<Customer> getCustomer(){
        Customer customer = new Customer();
        customer.setName("Harvey");
        customer.setId(44338855);
        customer.setAddress("Cape Town, ZA");
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}
