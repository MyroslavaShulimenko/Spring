package ReflectionsAndAnnotations.home.Tasks;

import lombok.Getter;

public class Employee {
    public  int id;
    public  String name;
    @Getter
    private  Double salary;
    private  String departament;

    public Employee(int id, String name, Double salary, String departament) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departament = departament;
    }
    private void changeDep(String newDep){
       // departament=

    }
}
