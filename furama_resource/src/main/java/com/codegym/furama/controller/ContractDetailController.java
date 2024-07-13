package com.codegym.furama.controller;

import com.codegym.furama.entity.Contract;
import com.codegym.furama.entity.ContractDetail;
import com.codegym.furama.service.IAttachServiceService;
import com.codegym.furama.service.IContractDetailService;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/contract_detail/list");
        modelAndView.addObject("contractDetails", contractDetailService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/contract_detail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("contracts", contractService.findAll());
        modelAndView.addObject("attachServices", attachServiceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute ContractDetail contractDetail) {
        ModelAndView modelAndView = new ModelAndView("/admin/contract_detail/create");
        modelAndView.addObject("contracts", contractService.findAll());
        modelAndView.addObject("attachServices", attachServiceService.findAll());
        contractDetailService.save(contractDetail);
        modelAndView.addObject("message", "Create Successfully");
        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/contract_detail/delete");
        modelAndView.addObject("contractDetail", contractDetailService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.remove(contractDetail.getContractDetailId());
        return "redirect:/admin/contractDetail/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/contract_detail/edit");
        modelAndView.addObject("contractDetail", contractDetailService.findById(id).get());
        modelAndView.addObject("contracts", contractService.findAll());
        modelAndView.addObject("attachServices", attachServiceService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/admin/contractDetail/list";
    }
}
