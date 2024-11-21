import easykanbanpoe.EasyKanbanPOE;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EasyKanbanPOETest {

    private EasyKanbanPOE app;

    @Before
public void setUp() throws Exception {
    app = new EasyKanbanPOE();
    app.createTask("Create Login", "Login functionality", "Mike Smith", 5, "To Do");
    app.createTask("Create Add Features", "Add new features to the app", "Edward Harrison", 8, "Doing");
    app.createTask("Create Reports", "Generate reports", "Samantha Paulson", 2, "Done");
    app.createTask("Add Arrays", "Add array implementation", "Glenda Oberholzer", 11, "To Do");
}


    @Test
    public void testCreateTask() {
        app.createTask("Test Task", "Test task description", "John Doe", 3, "To Do");
        String taskReport = app.showReports();
        
        assertTrue(taskReport.contains("Test Task"));
        assertTrue(taskReport.contains("John Doe"));
        assertTrue(taskReport.contains("3"));
    }

    @Test
    public void testDeleteTaskByName() {
        app.deleteTaskByName("Create Reports");
        String report = app.showReports();
        assertFalse(report.contains("Create Reports"));
    }

    @Test
    public void testShowLongestTaskDuration() {
        String longestTask = app.showLongestTaskDuration();
        assertTrue(longestTask.contains("Longest Task: Add Arrays"));
        assertTrue(longestTask.contains("Duration: 11 hours"));
    }

    @Test
    public void testShowReports() {
        String report = app.showReports();
        
        assertTrue(report.contains("Task Report:"));
        assertTrue(report.contains("Create Login"));
        assertTrue(report.contains("Create Add Features"));
        assertTrue(report.contains("Create Reports"));
        assertTrue(report.contains("Add Arrays"));
        assertTrue(report.contains("Mike Smith"));
        assertTrue(report.contains("Edward Harrison"));
        assertTrue(report.contains("Samantha Paulson"));
        assertTrue(report.contains("Glenda Oberholzer"));
    }

    @Test
    public void testSearchTask() {
        String taskDetails = app.searchTask("Create Add Features");
        assertTrue(taskDetails.contains("Create Add Features"));
        assertTrue(taskDetails.contains("Edward Harrison"));
    }
}
