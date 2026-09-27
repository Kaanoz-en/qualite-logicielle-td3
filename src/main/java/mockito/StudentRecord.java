package mockito;

public interface StudentRecord {
    boolean containsExamRecord(String examId);

    double findExamWeightedGrade(String examId);

    void addExamRecord(String examId, double weightedGrade);
}
