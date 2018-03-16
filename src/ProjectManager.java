import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectManager {

    private Map<String, List<Employee>> data;

    private Pair max;

    public ProjectManager(String dataPath) {
        List<Employee> employees = Parser.readEmployees(dataPath);
        data = new HashMap<>();
        employees.forEach(employee -> {
            String projectId = employee.getProjectId();
            if (!data.containsKey(projectId)) {
                data.put(projectId, new ArrayList<>());
            }
            data.get(projectId).add(employee);
        });
    }

    public Pair findMaxEmployees() {
        data.forEach((s, employees) -> {
            Pair p = findMax(employees);
            if (p != null) {
                max = max == null || max.calculateCommonDuration() < p.calculateCommonDuration() ?
                        p : max;
            }
        });
        return max;
    }

    private Pair findMax(List<Employee> employees) {
        Pair pair = null;
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                Pair p = new Pair(employees.get(i), employees.get(j));
                long duration = p.calculateCommonDuration();
                if (duration > 0) {
                    pair = pair == null || pair.calculateCommonDuration() < duration ?
                            p : pair;
                }
            }
        }
        return pair;
    }
}
