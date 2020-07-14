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
        bank.add(newCustomer);
        return newCustomer;
    }
    public Customer deleteCustomer(Customer deletedCustomer){
        System.out.println(bank.size());
        if(bank.remove(deletedCustomer)){
            System.out.println(bank.size());
        }
        return deletedCustomer;
    }
/*
    public Customer findCustomer (int accountID){
        for (Customer customer : bank) {
            if( accountID == customer.getAccountID()){
                return customer;
            }
        }
        return null;
    }
    */

    public Customer findCustomer (int accountID){
        if (finder.containsKey(accountID)){
            return finder.get(accountID);
        }
        return null;
    }


    public Customer updateCustomer(int accountID, Customer newCustomer){
        for (Customer customer : bank){
            if( accountID == customer.getAccountID()){
                bank.remove(new CustomerDAO().findCustomer(accountID));
                bank.add(newCustomer);
                 return newCustomer;
            }
        }
        return null;
    }

}
