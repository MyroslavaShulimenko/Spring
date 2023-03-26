package ReflectionsAndAnnotations.home2;

import ReflectionsAndAnnotations.home.StudentInfo;

import java.lang.reflect.Field;

public class School {
// используется инициализации  объекта класса Student
    @ReflectionsAndAnnotations.home.StudentInfo(name = "Tom", surname = "Tomas", age = 20)
    private  Student student1;
    @ReflectionsAndAnnotations.home.StudentInfo(name = "Eva", age = 21)
    private    Student student2;
    @ReflectionsAndAnnotations.home.StudentInfo(name = "Olga", surname = "Orlova")
    private  Student student3;
    @StudentInfo(surname = "Volkov", age = 19)
    private  Student student4;


    public static void main(String[] args) {
        School school = new School();
        Injector.inject(school);
        System.out.println(school.student1);
        System.out.println(school.student2);
        System.out.println(school.student3);
        System.out.println(school.student4);


    }


    public  class Injector {
        public static void inject(Object instance) {

            Field[] fields = instance.getClass().getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo studentInfo = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);

                    try {
                        field.set(instance, new Student(instance, studentInfo.name(), studentInfo.surname(), studentInfo.age()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
