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
        System.out.println(task.search("Заниматься"));

    }

    @Test
    public void searchAndNotFindSimpleTask() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        System.out.println(task.search("Рыба"));
    }

    @Test
    public void searchAndFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";

        EpicTask task = new EpicTask(11, subtasks);
        System.out.println(task.search("Изучить"));

    }

    @Test
    public void searchAndNotFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";

        EpicTask task = new EpicTask(11, subtasks);
        System.out.println(task.search("11"));  //поиск по id не настроен
    }

    @Test
    public void searchAndFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );


        System.out.println(task.search("Изучить"));

    }

    @Test
    public void searchAndNotFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );


        System.out.println(task.search("Точка"));
    }

    @Test
    public void searchAndFindMeetingTaskWithProject() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );


        System.out.println(task.search("017"));

    }
}
