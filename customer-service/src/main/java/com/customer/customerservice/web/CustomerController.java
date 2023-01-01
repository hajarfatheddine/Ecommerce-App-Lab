package com.customer.customerservice.web;

import com.customer.customerservice.entities.Customer;
import com.customer.customerservice.repositories.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping(path = "/customers/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.getCustomerById(id);
    }

    @GetMapping(path = "/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
