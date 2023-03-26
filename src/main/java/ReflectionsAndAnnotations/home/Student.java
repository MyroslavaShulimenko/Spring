package ReflectionsAndAnnotations.home;

import ReflectionsAndAnnotations.home2.School;

import java.lang.reflect.Field;

public class Student {
// аннотация используется для инициализации поля
    @StudentInfo(name = "Tom", surname = "Tomas", age = 20)
    private String student;
    @StudentInfo(name = "Eva", age = 21)
    private String student2;
    @StudentInfo(name = "Olga", surname = "Orlova")
    private String student3;
    @StudentInfo(surname = "Volkov", age = 19)
    private String student4;



//    public Student(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//


    public static void main(String[] args) throws Exception {
          Student student = new Student();
        Injector.inject(student);
        System.out.println(student.student);
        System.out.println(student.student2);
        System.out.println(student.student3);
        System.out.println(student.student4);

        Injector.injectAll(student);
        System.out.println(student.student);
        System.out.println(student.student2);
        System.out.println(student.student3);
        System.out.println(student.student4);

        //     Injector.injectAge(student);


        Class<? extends Student> clazz = student.getClass();
        Field field1 = clazz.getDeclaredField("student2");
        StudentInfo annotation = field1.getAnnotation(StudentInfo.class);
        System.out.println(annotation);
        System.out.println(annotation.name());
        System.out.println(annotation.surname());
        System.out.println(annotation.age());
    }


    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    try {
                       field.set(instance, annotation.name());
                        //  field.set(instance, annotation.surname());
                        //  field.set(instance, annotation.age());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // что-то пощло не так.... разобралась кажется/
        public static void injectAge(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    try {
                        field.set(instance, annotation.age());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void injectAll(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    try {
                        field.set(instance, annotation.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }


}
