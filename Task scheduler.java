import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {

    private Queue<String> highPriorityQueue = new LinkedList<>();
    private Queue<String> mediumPriorityQueue = new LinkedList<>();
    private Queue<String> lowPriorityQueue = new LinkedList<>();

    public void addTask(String task, String priority) {
        switch (priority.toLowerCase()) {
            case "high":
                highPriorityQueue.add(task);
                break;
            case "medium":
                mediumPriorityQueue.add(task);
                break;
            case "low":
                lowPriorityQueue.add(task);
                break;
            default:
                System.out.println("Invalid priority. Use high, medium, or low.");
        }
    }

    public String getNextTask() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.poll();
        } else if (!mediumPriorityQueue.isEmpty()) {
            return mediumPriorityQueue.poll();
        } else {
            return lowPriorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Task 1", "high");
        scheduler.addTask("Task 2", "medium");
        scheduler.addTask("Task 3", "low");
        scheduler.addTask("Task 4", "high");

        System.out.println("Next task: " + scheduler.getNextTask());
        System.out.println("Next task: " + scheduler.getNextTask());
        System.out.println("Next task: " + scheduler.getNextTask());
        System.out.println("Next task: " + scheduler.getNextTask());
    }
}
