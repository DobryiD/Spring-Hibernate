package com.springdemo.controller;


import com.springdemo.entity.Customer;
import com.springdemo.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomer(Model theModel){

        List<Customer> theCustomers=customerService.getCustomers();
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer=new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer theCustomer  ){

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        Customer theCustomer=customerService.getCustomer(theId);
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";

    }
    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel){
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";

    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName")String theName,Model theModel ){
        List<Customer> theCustomers=customerService.searchCustomers(theName);
        theModel.addAttribute("customers",theCustomers);
        return "list-customers";
    }





}
