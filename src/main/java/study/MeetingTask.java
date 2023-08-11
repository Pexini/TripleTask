package study;

public class MeetingTask extends Task {

    private String topic;
    private String project;
    private String start;

    public MeetingTask(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query) && project.contains(query)) {
            return true;
        }
        return false;
    }
}
