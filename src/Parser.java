import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static List<EmployeeWorkPeriod> readPeriods(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.map(line -> {
                String[] employeeData = line.split(",");
                if (employeeData.length == 4) {
                    return new EmployeeWorkPeriod(employeeData[0].trim(),
                            employeeData[1].trim(),
                            parseDate(employeeData[2].trim()),
                            parseDate(employeeData[3].trim()));
                } else {
                    throw new IllegalStateException("Input file error");
                }
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(0);
    }

    private static LocalDate parseDate(String date) {
        if (date == null || date.equals("NULL")) {
            return LocalDate.now();
        }
        return LocalDate.parse(date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}