public class Task {
    String Desc;
    int Priority;

    public Task(int Prio) {
        Priority = Prio;
        Desc += "Priority " + Priority;
    }

    public int getPriority() {
        return Priority;
    }

    public String getDesc() {
        return Desc;
    }
}
