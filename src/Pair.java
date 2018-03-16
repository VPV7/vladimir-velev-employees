import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pair {

    private Employee first;
    private Employee second;

    public Pair() {

    }

    public Pair(Employee first, Employee second) {
        this.first = first;
        this.second = second;
    }

    public long calculateCommonDuration() {
        if (first == null || second == null) {
            return 0;
        }
        LocalDate to = first.getDateTo().isBefore(second.getDateTo()) ?
                first.getDateTo() : second.getDateTo();
        LocalDate from = first.getDateFrom().isAfter(second.getDateFrom()) ?
                first.getDateFrom() : second.getDateFrom();
        long duration = ChronoUnit.DAYS.between(from, to);
        return duration > 0 ? duration : 0;
    }

    public Employee getFirst() {
        return first;
    }

    public void setFirst(Employee first) {
        this.first = first;
    }

    public Employee getSecond() {
        return second;
    }

    public void setSecond(Employee second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                ", duration=" + calculateCommonDuration() +
                '}';
    }
}
