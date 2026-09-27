package mockito.exceptions;

public class ExamGradeAlreadyRecordedException extends RuntimeException {
    public ExamGradeAlreadyRecordedException(){
        super("Exam grade was already added to student record.");
    }
}
