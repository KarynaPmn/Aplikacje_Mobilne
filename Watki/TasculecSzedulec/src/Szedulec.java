import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Szedulec {
    private int n;
    private List<Task> TaskList;

    public Szedulec(int n) {
        this.n = n;
        TaskList = new ArrayList<Task>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            TaskList.add(new Task(rand.nextInt(1, 10)));
        }
    }

    public List<Task> getTaskList() {
        return TaskList;
    }
}
