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


    @Test
    public void searchAndFindSimpleTask() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        assertTrue(task.matches("Заниматься"));
        assertTrue(task.matches("книгу"));

    }

    @Test
    public void searchAndNotFindSimpleTask() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        assertFalse(task.matches("11"));
        assertFalse(task.matches("Рыба"));
    }

    @Test
    public void searchAndFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";

        EpicTask task = new EpicTask(15, subtasks);
        assertTrue(task.matches("Изучить"));
        assertTrue(task.matches("мусор"));
    }

    @Test
    public void searchAndNotFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";

        EpicTask task = new EpicTask(11, subtasks);
        assertFalse(task.matches("11"));
        assertFalse(task.matches("цветок"));
    }

    @Test
    public void searchAndFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        assertTrue(task.matches("материалы"));
        assertTrue(task.matches("017"));
    }

    @Test
    public void searchAndNotFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        assertFalse(task.matches("11"));
        assertFalse(task.matches("цветок"));
    }

    @Test
    public void searchAndFindMeetingTaskWithProject() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        assertTrue(task.matches("017"));

    }

}
