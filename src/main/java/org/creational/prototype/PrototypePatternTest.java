package src.main.java.org.creational.prototype;

import java.util.List;

public class PrototypePatternTest {
    public static void main(String[] args) throws
            CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();
//Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("test5");

        List<String> list1 = empsNew1.getEmpList();
        list1.remove("test1");
        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}