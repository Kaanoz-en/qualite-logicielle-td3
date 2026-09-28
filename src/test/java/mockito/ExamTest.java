package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExamTest {

    private static final double ANY_GRADE = 0.84;
    private static final double ANY_WEIGHT = 0.5;
    private static final double ANY_WEIGHT_GRADE = 0.42;
    private static final String ANY_ID = "id";

    @Mock
    private Student studentMock;

    @Test
    public void givenAWeight_whenCalculateGrade_thenStudentCalculateExamGradeWithWeightedGrade(){
        Exam exam = new Exam(ANY_ID, studentMock, ANY_GRADE);

        exam.calculateGrade(ANY_WEIGHT);

        verify(studentMock).calculateExamGrade(ANY_ID, ANY_WEIGHT_GRADE);

    }
}
