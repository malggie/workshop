package org.goforjava.db;

import org.goforjava.domain.Department;
import org.goforjava.domain.Id;

import java.util.*;

public class DepartmentDB implements DB<Department> {

    private final Map<Id, Department> departmentMap = new HashMap<>();

    @Override
    public List<Department> findAll() {
        List<Department> listOfDepartments = new ArrayList<>();
        for (Map.Entry<Id, Department> entry : departmentMap.entrySet()) {
            listOfDepartments.add(entry.getValue());
        }
        return listOfDepartments;
    }

    @Override
    public Optional<Department> findById(Id id) {
        return Optional.ofNullable(departmentMap.get(id));
    }

    @Override
    public void put(Id id, Department toPut) {
        departmentMap.put(id, toPut);
    }
}
