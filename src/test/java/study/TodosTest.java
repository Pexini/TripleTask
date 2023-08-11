package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Call parents");

        String subtasks = "Молоко, Яйца, Хлеб";
        EpicTask epicTask = new EpicTask(55, subtasks);

        MeetingTask meetingTask = new MeetingTask(
                555,
                "Выкати 3й версии приложение",
                "Приложение НетоБанка",
                "Во вторник после обеда"

        );
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epicTask);
        todos.add(meetingTask);
        Task[] extended = {simpleTask, epicTask, meetingTask};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(extended, actual);
    }

}