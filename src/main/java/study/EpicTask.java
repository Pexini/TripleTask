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
        if (subtasks.contains(query)) {
            return true;
        }
        return false;
    }

    @Override
    public String search(String query) {
        if (subtasks.contains(query)) {
            return subtasks;
        }
        return "задача не найдена";
    }
}

