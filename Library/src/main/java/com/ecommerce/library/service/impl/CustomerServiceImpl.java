package com.ecommerce.library.service.impl;

import com.ecommerce.library.dto.CustomerDto;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.repository.CustomerRepository;
import com.ecommerce.library.repository.RoleRepository;
import com.ecommerce.library.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomerServiceImpl implements CustomerService {
    private RoleRepository roleRepository;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(RoleRepository roleRepository, CustomerRepository customerRepository) {
        this.roleRepository = roleRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setRoles(Collections.singletonList(roleRepository.findByName("CUSTOMER")));
        Customer customerToSave = customerRepository.save(customer);
        return mapperCustomerDto(customerToSave);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer saveInfo(Customer customer) {
        Customer customerToSave = customerRepository.findByUsername(customer.getUsername());
        customerToSave.setAddress(customer.getAddress());
        customerToSave.setCity(customer.getCity());
        customerToSave.setCountry(customer.getCountry());
        customerToSave.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customerToSave);
    }

    private CustomerDto mapperCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customerDto.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        return customerDto;
    }
}
