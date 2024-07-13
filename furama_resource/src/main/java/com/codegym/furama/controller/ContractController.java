package com.codegym.furama.controller;

import com.codegym.furama.entity.Contract;
import com.codegym.furama.entity.Customer;
import com.codegym.furama.service.IContractService;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin/contract")
@Controller
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IServiceService serviceService;

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/contract/list");
        modelAndView.addObject("contracts", contractService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("services", serviceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@Validated @ModelAttribute Contract contract, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/admin/contract/create");
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("services", serviceService.findAll());
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            contractService.save(contract);
            modelAndView.addObject("message", "Create Successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/contract/delete");
        modelAndView.addObject("contract", contractService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Contract contract){
        contractService.remove(contract.getContractId());
        return "redirect:/admin/contract/list";
    }

    @GetMapping("/search")
    public ModelAndView searchEmployee(@RequestParam("contractTotalMoney") Double contractTotalMoney, @RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/contract/list");
        modelAndView.addObject("contracts", contractService.findAllByContractTotalMoney(contractTotalMoney, PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/contract/edit");
        modelAndView.addObject("contract", contractService.findById(id).get());
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("services", serviceService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Contract contract){
        contractService.save(contract);
        return "redirect:/admin/contract/list";
    }
}
