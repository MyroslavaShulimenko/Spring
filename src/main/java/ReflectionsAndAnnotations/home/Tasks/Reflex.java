package ReflectionsAndAnnotations.home.Tasks;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.List;
@Getter
public class Reflex {
    public static void main(String[] args) throws ClassNotFoundException {
      Class tmployeeClass=Class.forName("org.example.rjtiki._2023_24.emp.Employee");
        try {
            Field field= tmployeeClass.getField("id");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }
}
