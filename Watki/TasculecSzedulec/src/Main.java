import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Szedulec szedulec = new Szedulec(5);
        List<Task> TasksList = szedulec.getTaskList();

        //  Dodać sortowanie
        for (Task task : TasksList) {
            Thread t = new Thread(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " " +
                        task.getDesc() + " " +
                        Thread.currentThread().getPriority()
                );
            });
            t.setPriority(task.getPriority());
            t.start();
            t.join();
        }

    }
}