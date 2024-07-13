package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.Service;
import com.codegym.furama.service.IRentTypeService;
import com.codegym.furama.service.IServiceService;
import com.codegym.furama.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin/service")
@Controller
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IRentTypeService rentTypeService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(value = "page", defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/admin/service/list");
        modelAndView.addObject("services", serviceService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView  modelAndView = new ModelAndView("/admin/service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createService(@Validated @ModelAttribute Service service, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/admin/service/create");
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            serviceService.save(service);
            modelAndView.addObject("service", new Service());
            modelAndView.addObject("message", "Create Successfully");
            return modelAndView;
        }
    }

    @GetMapping("/search")
    public ModelAndView searchEmployee(@RequestParam("name") String name, @RequestParam("standardRoom") String standardRoom, @RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/service/list");
        modelAndView.addObject("services", serviceService.findAllByServiceNameContainingAndStandardRoomContaining(name, standardRoom, PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/admin/service/delete");
        modelAndView.addObject("service", serviceService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Service service){
        serviceService.remove(service.getServiceId());
        return "redirect:/admin/service/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/admin/service/edit");
        modelAndView.addObject("service", serviceService.findById(id).get());
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Service service){
        serviceService.save(service);
        return "redirect:/admin/service/list";
    }
}
