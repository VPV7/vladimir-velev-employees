import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WorkPeriodPair {

    private EmployeeWorkPeriod first;
    private EmployeeWorkPeriod second;

    public WorkPeriodPair() {

    }

    public WorkPeriodPair(EmployeeWorkPeriod first, EmployeeWorkPeriod second) {
        this.first = first;
        this.second = second;
    }

    public String getProject() {
        return first.getProjectId();
    }

    public long calculateCommonDuration() {
        if (first == null || second == null || first.getProjectId().compareTo(second.getProjectId()) != 0) {
            return 0;
        }
        LocalDate to = first.getDateTo().isBefore(second.getDateTo()) ?
                first.getDateTo() : second.getDateTo();
        LocalDate from = first.getDateFrom().isAfter(second.getDateFrom()) ?
                first.getDateFrom() : second.getDateFrom();
        long duration = ChronoUnit.DAYS.between(from, to);
        return duration >= 0 ? duration+1 : 0;
    }

    public EmployeeWorkPeriod getFirst() {
        return first;
    }

    public void setFirst(EmployeeWorkPeriod first) {
        this.first = first;
    }

    public EmployeeWorkPeriod getSecond() {
        return second;
    }

    public void setSecond(EmployeeWorkPeriod second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "WorkPeriodPair{" +
                "first=" + first +
                ", second=" + second +
                ", duration=" + calculateCommonDuration() +
                '}';
    }
}