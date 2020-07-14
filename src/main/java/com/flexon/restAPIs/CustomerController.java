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
        customerDAO.addCustomer(newCustomer);
        return new ResponseEntity<>("Create a new customer ", HttpStatus.CREATED);
    }

    //Delete a customer
    @DeleteMapping(path = "/deleteCustomer")
    public ResponseEntity deleteCustomer(@RequestBody Customer deletedCustomer){
        customerDAO.deleteCustomer(deletedCustomer);
        return new ResponseEntity<>("Deleted a customer", HttpStatus.OK);
    }

    //find a specific customer
    @GetMapping(path = "/findCustomer")
    public ResponseEntity findCustomer(@RequestBody int accountID){
        customerDAO.findCustomer(accountID);
        return new ResponseEntity<>("Customer returned", HttpStatus.OK);
    }
    @PutMapping(path = "updateCustomer")
    public ResponseEntity updateCustomer(@RequestBody int accountID, Customer newCustomer){
        customerDAO.updateCustomer(accountID,newCustomer);
        return new ResponseEntity<>("Customer info updated", HttpStatus.OK);
    }

}
