package easykanbanpoe;

import java.util.ArrayList;
import java.util.List;

public class EasyKanban3POE {
    private User currentUser;
    private final List<Task> tasks = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public EasyKanban3POE() {
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean registerUser(String firstName, String lastName, String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }

        users.add(new User(firstName, lastName, username, password));
        return true;
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void createTask(String name, String description, String developer, int duration, String status) {
        Task task = new Task(name, description, developer, duration, status);
        tasks.add(task);
    }

    public boolean deleteTask(String taskName) {
        if (currentUser != null) { 
            return tasks.removeIf(task -> task.getName().equalsIgnoreCase(taskName));
        }
        return false;
    }

    public Task getTaskWithLongestDuration() {
        if (currentUser != null) { 
            Task longest = null;
            for (Task task : tasks) {
                if (longest == null || task.getDuration() > longest.getDuration()) {
                    longest = task;
                }
            }
            return longest;
        }
        return null;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    public String showLongestTaskDuration() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   public Task searchTaskByName(String taskName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static class User {
        private final String firstName;
        private final String lastName;
        private final String username;
        private final String password;

        public User(String firstName, String lastName, String username, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }
    }

    // Task class representing a task
    public static class Task {
        private final String name;
        private final String description;
        private final String developer;
        private final int duration;
        private final String status;

        public Task(String name, String description, String developer, int duration, String status) {
            this.name = name;
            this.description = description;
            this.developer = developer;
            this.duration = duration;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public String getDeveloper() {
            return developer;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Name Of [Task: " + name + ", Task Description: " + description + ", Who is The Developer: " + developer + 
                    ", Who Is The Duration: " + duration + " hours, What Is The Status: " + status + "]";
        }
    }
}
