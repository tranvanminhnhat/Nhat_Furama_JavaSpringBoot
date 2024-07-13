package com.codegym.furama.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{employeeId.empty}")
    private String employeeId;

    @Column(columnDefinition = "varchar(45)")
    @Size(min = 5, max = 45)
    @NotBlank(message = "{employeeName.empty}")
    private String employeeName;

    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{employeeBirthday.empty}")
    private Date employeeBirthday;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{employeeIdCard.empty}")
    private String employeeIdCard;

    @Column(columnDefinition = "double")
    @NotNull(message = "{employeeSalary.empty}")
    private Double employeeSalary;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{employeePhone.empty}")
    private String employeePhone;

    @Column(columnDefinition = "varchar(45)")
    private String employeeEmail;

    @Column(columnDefinition = "varchar(45)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "positionId",nullable = false,referencedColumnName = "positionId")
    @JsonBackReference
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId",nullable = false,referencedColumnName = "educationDegreeId")
    @JsonBackReference
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "divisionId",nullable = false,referencedColumnName = "divisionId")
    @JsonBackReference
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Contract> contracts;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public boolean supports(Class<?> clazz){
        return Employee.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors){
        Employee employee = (Employee) target;

        // validate employeeID
        String employeeId = employee.getEmployeeId();
        if (!employeeId.matches("^[N][V][0-9]{4}+$")){
            errors.rejectValue("employeeId", "employeeId.format");
        }

        // validate employeeIdCard
        String employeeIdCard = employee.getEmployeeIdCard();
        if (!employeeIdCard.matches("^[0-9]{9}+$")){
            errors.rejectValue("employeeIdCard", "employeeIdCard.format");
        }

        // validate employeeSalary
        Double employeeSalary = employee.getEmployeeSalary();
        if (employeeSalary < 0){
            errors.rejectValue("employeeSalary", "employeeSalary.value");
        }

        // validate employeePhone
        String employeePhone = employee.getEmployeePhone();
        if (!employeePhone.matches("^[0][9][01][0-9]{7}+$")){
            errors.rejectValue("employeePhone", "employeePhone.format");
        }
    }
}
