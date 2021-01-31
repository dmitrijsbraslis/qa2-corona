import model.Course;
import model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaObjectWorkshop {
    @Test
    public void workWithObjects() {
        Student dima = new Student();

        dima.setFirstName("Dmitrijs");
        dima.setLastName("Terepa");
        dima.setAge(19);
        dima.setEmail("sexyboy@gmail.com");

        Student marija = new Student("Marija", "Shilova", 18, "lapusjka@inbox.lv");

//        marija.setFirstName("Maria");
//        marija.setLastName("Shilova");
//        marija.setAge(18);
//        marija.setEmail("lapusjka@inbox.lv");

//        System.out.println(dima.getFirstName() + " " + dima.getLastName());
//        System.out.println(dima.getFullName());
//        System.out.println(marija.getFirstName() + " " + marija.getLastName());
//        System.out.println(marija.getFullName());

        List<Student> students = new ArrayList<Student>();
        students.add(dima);
        students.add(marija);
        students.add(new Student("Dmitrijs", "Alibaba", 100500, "test@test.lv"));

        Course qa2 = new Course("QA2 - Automation", 7, students);
        qa2.addStudent(new Student("Sofiia", "Slepchenko", 18, "sofa_da_best@gmail.com"));

        qa2.printInfo();
    }
}
