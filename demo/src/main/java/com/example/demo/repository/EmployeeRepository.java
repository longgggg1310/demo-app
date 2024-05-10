package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Employee;

import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "Select * from employee where first_name = :firstName", nativeQuery = true)
    public List<Employee> findAllByFirstName(@Param("firstName") String firstName);
}
