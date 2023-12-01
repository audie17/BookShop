package fr.efrei.factory;


import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class EmployeeFactory {

    public static Employee createEmployee(int emp_id, String name, String surname, String rayon) {
        if (Helper.isNullorEmpty(name) || Helper.isNullorEmpty(surname) || Helper.isNullorEmpty(rayon))
            return null;

        if (emp_id <= 0)
            return null;

        return new Employee.Builder()
                .setEmp_id(emp_id)
                .setName(name)
                .setSurname(surname)
                .setRayon(rayon)
                .build();
    }
}

