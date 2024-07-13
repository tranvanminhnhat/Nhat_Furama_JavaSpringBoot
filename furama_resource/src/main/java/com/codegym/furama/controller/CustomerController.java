package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin/customer")
@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView  modelAndView = new ModelAndView("/admin/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/admin/customer/create");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            customerService.save(customer);
            modelAndView.addObject("message", "Create Successfully");
            return modelAndView;
        }
    }

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(value = "page", defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/admin/customer/list");
        modelAndView.addObject("customers", customerService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchCustomer(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam(value = "page", defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/admin/customer/list");
        modelAndView.addObject("customers", customerService.findAllByCustomerNameContainingAndCustomerAddressContaining(name, address, PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/admin/customer/delete");
        modelAndView.addObject("customer", customerService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer){
        customerService.remove(customer.getCustomerId());
        return "redirect:/admin/customer/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/admin/customer/edit");
        modelAndView.addObject("customer", customerService.findById(id).get());
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/admin/customer/list";
    }
}
