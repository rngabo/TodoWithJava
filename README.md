##  Todo Program with MySQL Database

This is a simple Todo Program written in Java that uses a MySQL database to store and manage tasks. The program allows you to add, list, and delete tasks from the database.

# Installation

Prerequisites

Ensure that you have Java Development Kit (JDK) installed on your system. You can download it from the Oracle website: https://jdk.java.net/
Make sure you have MySQL server installed and running on your system. You can download it from the official MySQL website: https://dev.mysql.com/downloads/mysql/
Download the source code
Clone this repository or download the source code as a ZIP file and extract it to a directory of your choice.
Set up the MySQL database
Open a MySQL client (e.g., MySQL Workbench or the MySQL command-line client) and connect to your local MySQL server.
Create a new database named todo_db by running the following command:
sql
CREATE DATABASE todo_db;

### Configure the database connection

* Open the `TodoProgramMysql.java` file in a text editor.
* Locate the section where the database connection parameters are defined:

```java
String url = "jdbc:mysql://localhost:3306/todo_db";
String username = "your_username";
String password = "your_password";

Replace your_username with your MySQL username and your_password with your MySQL password.
Compile and run the program
Open a terminal or command prompt.
Navigate to the directory where the TodoProgramMysql.java file is located.
Compile the Java source code by running the following command:


javac TodoProgramMysql.java


java -cp "/path/to/mysql-connector-java.jar:." TodoProgramMysql


Replace `/path/to/mysql-connector-java.jar` with the actual path to the MySQL Connector/J JAR file on your system.

The program will start, and you can interact with the Todo application through the console.

## Usage

After running the program, you can use the following commands to interact with the Todo application:

* `add`: Add a new task.
* `list`: List all tasks.
* `delete`: Delete a task.
* `exit`: Exit the program.

Follow the on-screen prompts to enter the necessary information for each command.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue in this repository.

## License

This program is licensed under the MIT License.