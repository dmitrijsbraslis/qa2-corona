package model;

public class Registration {
    private QaStudent student;
    private String code;
    private String comment;
    private Courses courses;

    public QaStudent getStudent() {
        return student;
    }

    public void setStudent(QaStudent student) {
        this.student = student;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
