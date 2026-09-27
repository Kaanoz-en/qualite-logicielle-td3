package mockito;

import mockito.exceptions.ExamGradeAlreadyRecordedException;

public class Student {
    private final StudentRecord studentRecord;
    private double finalGrade = 0;

    public Student(StudentRecord studentRecord) {
        this.studentRecord = studentRecord;
    }
    public void calculateExamGrade(String examId, double weightedGrade) {
        if (studentRecord.containsExamRecord(examId)) {
            throw new ExamGradeAlreadyRecordedException();
        } else {
            studentRecord.addExamRecord(examId, weightedGrade);
        }

        finalGrade += weightedGrade;
    }

    public void publishFinalGrade(GradePublisher gradePublisher) {
        gradePublisher.publish(finalGrade);
    }
}
