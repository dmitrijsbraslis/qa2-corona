import model.Course;
import model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaObjectWorkshop {
    @Test
    public void workWithObjects() {
        Student lena = new Student();

        lena.setFirstName("Lena");
        lena.setLastName("Tripathi");
        lena.setAge(18);
        lena.setEmail("lapusjka@inbox.lv");

        Student raimonds = new Student("Raimonds", "Geislers", 19, "sexyboy@gmail.com");

//        raimonds.setFirstName("Raimonds");
//        raimonds.setLastName("Geislers");
//        raimonds.setAge(19);
//        raimonds.setEmail("sexyboy@gmail.com");

//        System.out.println(lena.getFirstName() + " " + lena.getLastName());
//        System.out.println(lena.getFullName());
//        System.out.println(raimonds.getFirstName() + " " + raimonds.getLastName());
//        System.out.println(raimonds.getFullName());

        List<Student> students = new ArrayList<Student>();
        students.add(lena);
        students.add(raimonds);
        students.add(new Student("Liga", "BlaBla", 18, "liga@gmail.com"));

        Course qa2 = new Course("QA2 - Automation", 3, students);
        qa2.addStudent(new Student("Dmitrijs", "Alibaba", 100500, "tester@test.lv"));

        qa2.printInfo();
    }
}
