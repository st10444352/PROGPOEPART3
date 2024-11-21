package easykanbanpoe;

public class Task {
    private final String name;
    private final String description;
    private final String developerDetails;
    private final int duration;
    private final String status;
    private final int taskId;

    public Task(String name, int taskId, String description, String developerDetails, int duration, String status) {
        this.name = name;
        this.taskId = taskId;
        this.description = description;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + "\n" +
               "Task Name: " + name + "\n" +
               "Description: " + description + "\n" +
               "Assigned Developer: " + developerDetails + "\n" +
               "Duration: " + duration + " hours\n" +
               "Status: " + status + "\n";
    }
}
