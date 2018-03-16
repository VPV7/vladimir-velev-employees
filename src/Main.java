public class Main {

    public static void main(String[] args) {
        String path = args.length == 0 ?
                "data.txt" : args[0];
        ProjectManager projectManager = new ProjectManager(path);
        Pair employees = projectManager.findMaxEmployees();
        System.out.println(employees);
    }
}