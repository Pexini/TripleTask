package study;

public class EpicTask extends Task {

    public String subtasks;

    public EpicTask(int id, String subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        if (Integer.toString(id).contains(query)) {
            return true;
        } else {
            if (subtasks.contains(query)) {
                return true;
            }
            return false;
        }
    }
}
