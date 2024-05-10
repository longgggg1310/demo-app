package com.example.demo.util;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDocument;

public class Mapper {
    public static EmployeeDocument convertToEmployeeDocument(Employee employee) {
        EmployeeDocument employeeDocument = new EmployeeDocument();
        employeeDocument.setId(employee.getId());
        employeeDocument.setFirstName(employee.getFirstName());
        employeeDocument.setLastName(employee.getLastName());
        employeeDocument.setAddress(employee.getAddress());
        employeeDocument.setAvatar(employee.getAvatar());
        return employeeDocument;
    }
    
}
