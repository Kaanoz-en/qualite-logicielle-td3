package mockito;

public class Exam {

    private String id;
    private Student student;
    private double grade;

    public Exam(String id, Student student, double grade){
        this.id = id;
        this.student = student;
        this.grade = grade;
    }

    public void calculateGrade(double weight){
        double weightedGrade = grade * weight;
        student.calculateExamGrade(id, weightedGrade);
    }
}
