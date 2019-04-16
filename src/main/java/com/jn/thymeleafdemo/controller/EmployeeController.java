package com.jn.thymeleafdemo.controller;

import com.jn.thymeleafdemo.dao.DepartmentDao;
import com.jn.thymeleafdemo.dao.EmployeeDao;
import com.jn.thymeleafdemo.entities.Department;
import com.jn.thymeleafdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getAll(Model model) {
        Collection<Employee> all = employeeDao.getAll();

        model.addAttribute("emps", all);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toaddpage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts", departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toeditpage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "/emp/add";
    }


    @PutMapping("/emp")
    public String update(Employee employee) {
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteemp(@PathVariable("id") Integer id){
        employeeDao.delete(id);

        return "redirect:/emps";
    }

}
