import java.time.LocalDate;

public class EmployeeWorkPeriod {

    private String id;
    private String projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public EmployeeWorkPeriod(String id, String projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.id = id;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getId() {
        return id;
    }

    public String getProjectId() {
        return projectId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "EmployeeWorkPeriod{" +
                "id='" + id + '\'' +
                ", projectId='" + projectId + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}