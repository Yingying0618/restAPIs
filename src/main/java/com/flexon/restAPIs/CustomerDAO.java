package com.flexon.restAPIs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomerDAO {
    private ArrayList <Customer> bank = new ArrayList<>();
    //private HashMap<Integer,Customer> finder = new HashMap<>();

    //add customer to DAO
    public CustomerDAO (){
        bank.add( new Customer(1,"Kelly", "Liu",
                "123456@gmail.com", 123456789));
        bank.add( new Customer(2,"Kate", "Yan",
                "Kate.Yan@gmail.com", 987654321));
        bank.add( new Customer(3,"Jerry", "Water",
                "Jerry.Water@gmail.com", 252525335));
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

    public boolean deleteCustomer(int accountID){
        for (Customer customer : bank){
            if (accountID == customer.getAccountID()){
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
