import easykanbanpoe.EasyKanban3POE;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EasyKanban3POETest {

    private EasyKanban3POE app;

    @Before
    public void setUp() throws Exception {
        app = new EasyKanban3POE();
        app.registerUser("John", "Doe", "johndoe", "password123");
        app.loginUser("johndoe", "password123");
        app.createTask("Create Login", "Implement login functionality", "John Doe", 5, "To Do");
        app.createTask("Create Reports", "Generate reports for the app", "John Doe", 3, "In Progress");
        app.createTask("Fix Bugs", "Fix bugs in the system", "John Doe", 8, "To Do");
    }

    @Test
    public void testRegisterUser() {
        boolean result = app.registerUser("Alice", "Smith", "alicesmith", "password456");
        assertTrue(result);
        result = app.registerUser("John", "Doe", "johndoe", "password123");
        assertFalse(result);
    }

    @Test
    public void testLoginUser() {
        boolean result = app.loginUser("johndoe", "password123");
        assertTrue(result);
        result = app.loginUser("johndoe", "wrongpassword");
        assertFalse(result);
    }

    @Test
    public void testCreateTask() {
        app.createTask("Create Dashboard", "Design the dashboard", "Jane Doe", 6, "To Do");
        assertEquals(4, app.getTasks().size());
        assertTrue(app.getTasks().get(3).getName().equals("Create Dashboard"));
    }

    @Test
    public void testDeleteTask() {
        boolean result = app.deleteTask("Create Reports");
        assertTrue(result);

        result = app.deleteTask("Non-Existent Task");
        assertFalse(result);
    }

    @Test
    public void testGetTaskWithLongestDuration() {
        EasyKanban3POE.Task longestTask = app.getTaskWithLongestDuration();
        
        assertNotNull(longestTask);
        assertEquals("Fix Bugs", longestTask.getName());
    }

    @Test
    public void testGetCurrentUser() {
        EasyKanban3POE.User currentUser = app.getCurrentUser();
        assertNotNull(currentUser);
        assertEquals("John Doe", currentUser.getFullName());
    }

    @Test
    public void testShowLongestTaskDuration() {
        try {
            app.showLongestTaskDuration();
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testSearchTaskByName() {
        try {
            app.searchTaskByName("Create Reports");
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
        }
    }
}


