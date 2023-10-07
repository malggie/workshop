package org.goforjava.domain;

import org.goforjava.db.DB;

import java.time.LocalDate;
import java.util.*;

public class WorkshopEmployeeStatsService implements EmployeeStatsService{

    private final DB<Employee> employeeDB;
    private final DB<Department> departmentDB;

    public WorkshopEmployeeStatsService(DB<Employee> employeeDB, DB<Department> departmentDB) {
        this.employeeDB = employeeDB;
        this.departmentDB = departmentDB;
    }

    @Override
    public List<Employee> findEmployeesOlderThen(long years) {
        List<Employee> findEmployee = employeeDB.findAll();
        List<Employee> employeesOlder = new ArrayList<>();
        for (Employee employee : findEmployee) {
        if (LocalDate.now().getYear() - employee.getBirthDate().getYear() >= years) {
                employeesOlder.add(employee);
            }
        }
        return employeesOlder;
    }

    @Override
    public List<Employee> findThreeTopCompensatedEmployees() {
        return List.of();
    }

    @Override
    public Optional<Department> findDepartmentWithLowestCompensationAverage() {
        return Optional.empty();
    }

    @Override
    public List<Employee> findEmployeesBasedIn(Location location) {
        return List.of();
    }

    @Override
    public Map<Integer, Long> countEmployeesByHireYear() {
        return Map.of();
    }

    @Override
    public Map<Location, Long> countEmployeesByLocation() {
        return Map.of();
    }
}
