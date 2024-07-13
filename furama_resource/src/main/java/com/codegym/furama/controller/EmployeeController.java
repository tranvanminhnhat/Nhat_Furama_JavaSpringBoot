package com.codegym.furama.controller;

import com.codegym.furama.entity.Employee;
import com.codegym.furama.service.IDivisionService;
import com.codegym.furama.service.IEducationDegreeService;
import com.codegym.furama.service.IEmployeeService;
import com.codegym.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin/employee")
@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IDivisionService divisionService;

    @Autowired
    IEducationDegreeService educationDegreeService;

    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/list");
        modelAndView.addObject("employees", employeeService.findAll(PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchEmployee(@RequestParam("name") String search, @RequestParam("id") String id, @RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/list");
        modelAndView.addObject("employees", employeeService.findAllByEmployeeNameContainingAndEmployeeIdContaining(search, id, PageRequest.of(page, 5)));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/delete");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Employee employee) {
        employeeService.remove(employee.getEmployeeId());
        return "redirect:/admin/employee/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positions", positionService.findAll());
        modelAndView.addObject("divisions", divisionService.findAll());
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/create");
        modelAndView.addObject("positions", positionService.findAll());
        modelAndView.addObject("divisions", divisionService.findAll());
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            employeeService.save(employee);
            modelAndView.addObject("employee", new Employee());
            modelAndView.addObject("message", "Create Successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/admin/employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        modelAndView.addObject("positions", positionService.findAll());
        modelAndView.addObject("divisions", divisionService.findAll());
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/admin/employee/list";
    }
}
