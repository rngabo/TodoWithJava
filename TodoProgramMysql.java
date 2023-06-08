import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoProgramMysql {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            System.out.println("Connected to the database.");

            createTableIfNotExists(connection);

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
                        addTask(connection, task);
                        System.out.println("Task added successfully.");
                        break;
                    case 2:
                        viewTasks(connection);
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
        } catch (SQLException e) {
            System.out.println("Connection failed. Error message: " + e.getMessage());
        }
    }

    private static void createTableIfNotExists(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks (id INT AUTO_INCREMENT PRIMARY KEY, task VARCHAR(255))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        }
    }

    private static void addTask(Connection connection, String task) throws SQLException {
        String insertSQL = "INSERT INTO tasks (task) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, task);
            preparedStatement.executeUpdate();
        }
    }

    private static void viewTasks(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM tasks";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            List<String> tasks = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("task");
                tasks.add(id + ". " + task);
            }

            if (tasks.isEmpty()) {
                System.out.println("No tasks found.");
            } else {
                System.out.println("Tasks:");
                for (String task : tasks) {
                    System.out.println(task);
                }
            }
        }
    }
}
