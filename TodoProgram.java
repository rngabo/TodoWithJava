import java.util.ArrayList;
import java.util.Scanner;

public class TodoProgram {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== Todo Program =====");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void addTask(String task) {
        todoList.add(task);
    }

    private static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }
}
