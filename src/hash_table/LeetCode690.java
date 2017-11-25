package hash_table;

import base.Employee;

import java.util.ArrayList;
import java.util.List;

public class LeetCode690 {
    private List<Employee> generateList() {
        List<Employee> employeeList = new ArrayList<>();
        List<Integer> subIdList = new ArrayList<>();
        subIdList.add(2);
        subIdList.add(3);
        Employee employee = new Employee(1, 5, subIdList);
        employeeList.add(employee);
        employee = new Employee(2, 3, null);
        employeeList.add(employee);
        employee = new Employee(3, 3, null);
        employeeList.add(employee);
        return employeeList;
    }

    public static void main(String[] args) {
        LeetCode690 leetCode690 = new LeetCode690();
        System.out.println(leetCode690.getImportance(leetCode690.generateList(), 1));
    }

    private int getImportance(List<Employee> employees, Employee employee) {
        if (employee.subordinates == null || employee.subordinates.size() <= 0) {
            return employee.importance;
        }
        List<Employee> subEmployee = new ArrayList<>();
        for (int i = 0; i < employee.subordinates.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (employee.subordinates.get(i) == employees.get(j).id) {
                    subEmployee.add(employees.get(j));
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < subEmployee.size(); i++) {
            sum += getImportance(employees, subEmployee.get(i));
        }
        return sum + employee.importance;
    }

    public int getImportance(List<Employee> employees, int id) {
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                employee = employees.get(i);
            }
        }
        if (employee == null) return 0;
        return getImportance(employees, employee);
    }
}
