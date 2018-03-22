import java.util.ArrayList;
import java.util.List;

public class EmployeePair {

    private String first;

    private String second;

    private long duration;

    private List<String> projects = new ArrayList<>();

    public EmployeePair() {
    }

    public EmployeePair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public void addProject(String project) {
        projects.add(project);
    }

    public boolean containsProject(String project) {
        return projects.contains(project);
    }

    public String calculateUniqueKey() {
        return Integer.parseInt(first) < Integer.parseInt(second) ?
                first + ":" + second :
                second + ":" + first;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void addToDuration(long days) {
        duration += days;
    }

    @Override
    public String toString() {
        return "EmployeePair{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", duration=" + duration +
                '}';
    }
}