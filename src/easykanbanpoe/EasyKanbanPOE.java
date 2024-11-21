package easykanbanpoe;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class EasyKanbanPOE {

    private final List<Task> tasks = new ArrayList<>();

    public EasyKanbanPOE() {
    } 

    public void registerUser(String username, String password) {
        System.out.println("User registered: " + username);
    }

    public String showLongestTaskDuration() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }

        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getDuration() > longestTask.getDuration()) {
                longestTask = task;
            }
        }

        return "Longest Task: " + longestTask.getName() + "\nDuration: " + longestTask.getDuration() + " hours";
    }

    public String showReports() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Task Report:\n\n");

        for (Task task : tasks) {
            reportBuilder.append("Task Name: ").append(task.getName())
                    .append("\nDescription: ").append(task.getDescription())
                    .append("\nDeveloper: ").append(task.getDeveloperDetails())
                    .append("\nDuration: ").append(task.getDuration())
                    .append("\nStatus: ").append(task.getStatus())
                    .append("\n\n");
        }

        return reportBuilder.toString();
    }

    public void createTask(String name, String description, String developerDetails, int duration, String status) {
        int taskId = tasks.size() + 1;
        Task newTask = new Task(name, taskId, description, developerDetails, duration, status);
        tasks.add(newTask);
    }

    public void deleteTaskByName(String taskName) {
        tasks.removeIf(task -> task.getName().equalsIgnoreCase(taskName));
    }

    public String searchTask(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                return task.toString();
            }
        }
        return "Task not found";
    }

    public void startApp() {
        JOptionPane.showMessageDialog(null, "Welcome to Easy Kanban! Now you can manage tasks.");
    }
}
