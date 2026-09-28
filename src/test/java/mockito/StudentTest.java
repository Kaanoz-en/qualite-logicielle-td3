package mockito;


import mockito.exceptions.ExamGradeAlreadyRecordedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentTest {

    private static final String ANY_EXAM_ID = "1123";
    private static final double ANY_WEIGHT_GRADE = 0.5;

    private Student student;

    @Mock
    StudentRecord studentRecordMock;

    @Mock
    GradePublisher gradePublisherMock;

    @BeforeEach
    public void createStudent(){
        student = new Student(studentRecordMock);
    }

    @Test
    public void givenExistingExamRecord_whenCalculateExamGrade_thenThrowExamGradeAlreadyRecordedException(){
        when(studentRecordMock.containsExamRecord(ANY_EXAM_ID)).thenReturn(true);

        Executable calculateExamGrade = () -> student.calculateExamGrade(ANY_EXAM_ID,ANY_WEIGHT_GRADE);

        assertThrows(ExamGradeAlreadyRecordedException.class, calculateExamGrade);
    }

    @Test
    public void givenUnexistingExamRecord_whenCalculateExamGrade_thenRecordIsAddedToStudentRecord(){
        when(studentRecordMock.containsExamRecord(ANY_EXAM_ID)).thenReturn(false);

        student.calculateExamGrade(ANY_EXAM_ID,ANY_WEIGHT_GRADE);

        verify(studentRecordMock).addExamRecord(ANY_EXAM_ID, ANY_WEIGHT_GRADE);
    }

    @Test
    public void givenNoExamGradeCalculated_whenPublishFinalGrade_thenPublish0(){
        student.publishFinalGrade(gradePublisherMock);

        verify(gradePublisherMock).publish(0);

    }

    @Test
    public void givenMultipleExamGradeCalculated_whenPublishFinalGrade_thenPublishSumsOfGrade(){
        when(studentRecordMock.containsExamRecord(ANY_EXAM_ID)).thenReturn(false);
        student.calculateExamGrade(ANY_EXAM_ID,ANY_WEIGHT_GRADE);
        String ANY_OTHER_EXAM_ID = "IFT293";
        double ANY_OTHER_WEIGHT_GRADE = 0.4;
        student.calculateExamGrade(ANY_OTHER_EXAM_ID,ANY_OTHER_WEIGHT_GRADE);
        double expectedSumOfGrades = 0.9;

        student.publishFinalGrade(gradePublisherMock);

        verify(gradePublisherMock).publish(expectedSumOfGrades);
    }

}
