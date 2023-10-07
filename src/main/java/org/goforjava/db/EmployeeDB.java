package org.goforjava.db;

import org.goforjava.domain.Department;
import org.goforjava.domain.Employee;
import org.goforjava.domain.Id;

import java.util.*;

public class EmployeeDB implements DB<Employee> {

    private final Map<Id, Employee> employeeMap = new HashMap<>();

    @Override
    public List<Employee> findAll() {
        List<Employee> listOfEmployees = new ArrayList<>();
        for (Map.Entry<Id, Employee> entry : employeeMap.entrySet()) {
            listOfEmployees.add(entry.getValue());
        }
        return listOfEmployees;
    }

    @Override
    public Optional<Employee> findById(Id id) {

        return Optional.ofNullable(employeeMap.get(id));
    }

    @Override
    public void put(Id id, Employee toPut) {
        employeeMap.put(id, toPut);
    }
}
