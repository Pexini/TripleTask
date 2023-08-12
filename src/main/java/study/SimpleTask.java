package study;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

    @Override
    public String search(String query) {
        if (title.contains(query)) {
            return title;
        }
        return "задача не найдена";
    }
}
