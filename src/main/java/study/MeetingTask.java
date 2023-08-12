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
        return (topic.contains(query) || (project.contains(query)));

    }

    @Override
    public String search(String query) {
        if (topic.contains(query)) {
            return topic + id + project + start;
        }
        if (project.contains(query)) {
            return project + id + project + start;
        }
        return "задача не найдена";
    }
}
