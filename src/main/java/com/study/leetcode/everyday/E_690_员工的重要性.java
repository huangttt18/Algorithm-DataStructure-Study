package com.study.leetcode.everyday;

import java.util.*;

/**
 * 690. 员工的重要性
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_690_员工的重要性 {

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    static Map<Integer, Employee> importanceMap = new HashMap<>();

    public static int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        for (Employee employee : employees) {
            importanceMap.put(employee.id, employee);
        }
        return get(id);
    }

    private static int get(int id) {
        Employee master = importanceMap.get(id);
        int ans = master.importance;
        for (int oid : master.subordinates) {
            Employee other = importanceMap.get(oid);
            ans += other.importance;
            for (int sub : other.subordinates) ans += get(sub);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee();
        e.id = 1;
        e.importance = 5;
        e.subordinates = Arrays.asList(2, 3);
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = Arrays.asList(4);
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 4;
        Employee e4 = new Employee();
        e4.id = 4;
        e4.importance = 1;
        employees.add(e);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        int id = 1;
        System.out.println(getImportance(employees, id));
    }
}
