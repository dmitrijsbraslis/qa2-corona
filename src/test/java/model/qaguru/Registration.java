package model.qaguru;

public class Registration {
    private QaStudent student;
    private String discount;
    private String comment;
    private Courses course;

    public QaStudent getStudent() {
        return student;
    }

    public void setStudent(QaStudent student) {
        this.student = student;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}
