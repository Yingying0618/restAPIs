package com.flexon.restAPIs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class CustomerDAO {
    private ArrayList <Customer> bank = new ArrayList<>();
    private HashMap<Integer,Customer> finder = new HashMap<>();

    public CustomerDAO (){
        bank.add( new Customer(1,"Kelly", "Liu",
                "123456@gmail.com", 123456789));
    }

    public ArrayList<Customer> getAllCustomer() {
        return bank;
    }

    public Customer addCustomer(Customer newCustomer){
        for (Customer customer : bank){
            if ( newCustomer.getAccountID() == customer.getAccountID()){
                return null;
            }
        }
        bank.add(newCustomer);
        return newCustomer;
    }

    public boolean deleteCustomer(Customer deletedCustomer){
        for (Customer customer : bank){
            if (deletedCustomer.getAccountID() == customer.getAccountID()){
                bank.remove(customer);
                return true;
            }
        }
        return false;
    }

    public Customer findCustomer (int accountID){
        for (Customer customer : bank) {
            if( accountID == customer.getAccountID()){
                return customer;
            }
        }
        return null;
    }


    public Customer updateCustomer( Customer newCustomer){
        for (Customer customer : bank){
            if( newCustomer.getAccountID() == customer.getAccountID()){
                bank.remove(customer);
                bank.add(newCustomer);
                 return newCustomer;
            }
        }
        return null;
    }

}
