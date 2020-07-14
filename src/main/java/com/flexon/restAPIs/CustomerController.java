package com.flexon.restAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO = new CustomerDAO();

    //Get all customer
    @GetMapping(path="/getAllCustomers")
    public ArrayList <Customer> getAllCustomers(){
        return customerDAO.getAllCustomer();
    }

    //Add a new customer
    @PostMapping(path="/addNewCustomer")
    public ResponseEntity addNewCustomer(@RequestBody Customer newCustomer){
        Customer c = customerDAO.addCustomer(newCustomer);
        if (c != null){
            return new ResponseEntity<>("Created a new customer ", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("CustomerID already exist", HttpStatus.OK);

    }

    //Delete a customer
    @DeleteMapping(path = "/deleteCustomer/{accountID}")
    public ResponseEntity deleteCustomer(@PathVariable int accountID){
        boolean status = customerDAO.deleteCustomer(accountID);
        if (status == true) {
            return new ResponseEntity<>("Deleted a customer", HttpStatus.OK);
        }
        return new ResponseEntity<>("CustomerID not found", HttpStatus.OK);
    }

    //find a specific customer
    @GetMapping(path = "/findCustomer/{accountID}")
    public ResponseEntity findCustomer(@PathVariable int accountID){
        Customer c = customerDAO.findCustomer(accountID);
        if (c != null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        }
        return new ResponseEntity<>("CustomerID not found", HttpStatus.OK);
    }
    @PutMapping(path = "updateCustomer/{accountID}")
    public ResponseEntity updateCustomer( @RequestBody Customer newCustomer){
        Customer c = customerDAO.updateCustomer(newCustomer);
        if (c != null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        }
        return new ResponseEntity<>("CustomerID not found", HttpStatus.OK);
    }

}
