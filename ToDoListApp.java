import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static int getUserChoice() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine().trim();
        if (task.isEmpty()) {
            System.out.println("Task description cannot be empty.");
        } else {
            tasks.add(task);
            System.out.println("Task added.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        System.out.println("Remove task by:");
        System.out.println("1. Index");
        System.out.println("2. Name");
        System.out.print("Enter your choice (1 or 2): ");
        int choice;
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                choice = Integer.parseInt(input);
                break;
            } else {
                System.out.print("Invalid input. Enter 1 or 2: ");
            }
        }

        switch (choice) {
            case 1:
                removeTaskByIndex();
                break;
            case 2:
                removeTaskByName();
                break;
        }
    }

    private static void removeTaskByIndex() {
        viewTasks();
        System.out.print("Enter the task number to remove: ");
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= tasks.size()) {
                    String removed = tasks.remove(index - 1);
                    System.out.println("Removed task: " + removed);
                    break;
                } else {
                    System.out.print("Invalid index. Enter a number between 1 and " + tasks.size() + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }

    private static void removeTaskByName() {
        System.out.print("Enter the exact task description to remove: ");
        String name = scanner.nextLine().trim();
        boolean removed = tasks.remove(name);
        if (removed) {
            System.out.println("Task removed.");
        } else {
            System.out.println("No task found with the given description.");
        }
    }
}