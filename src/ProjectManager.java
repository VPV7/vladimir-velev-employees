import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectManager {

    List<EmployeeWorkPeriod> employeeWorkPeriods;

    public ProjectManager(String dataPath) {
        employeeWorkPeriods = Parser.readPeriods(dataPath);
    }

    public EmployeePair findMax() {
        Map<String, EmployeePair> pairs = new HashMap<>();
        for (int i = 0; i < employeeWorkPeriods.size() - 1; i++) {
            for (int j = i + 1; j < employeeWorkPeriods.size(); j++) {
                WorkPeriodPair periodPair = new WorkPeriodPair(employeeWorkPeriods.get(i),
                        employeeWorkPeriods.get(j));
                EmployeePair employeePair = new EmployeePair(periodPair.getFirst().getId(),
                        periodPair.getSecond().getId());
                long duration = periodPair.calculateCommonDuration();
                if (duration == 0) {
                    continue;
                }
                String key = employeePair.calculateUniqueKey();
                if (!pairs.containsKey(key)) {
                    pairs.put(key, new EmployeePair(periodPair.getFirst().getId(), periodPair.getSecond().getId()));
                }
                EmployeePair pair = pairs.get(key);
                if (!pair.containsProject(periodPair.getProject())) {
                    pair.addToDuration(duration);
                    pair.addProject(periodPair.getProject());
                }
            }
        }
        return pairs.values().stream().max((o1, o2) -> (int)(o1.getDuration() - o2.getDuration())).orElse(null);
    }
}