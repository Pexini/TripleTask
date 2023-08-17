package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskTest {
    @Test
    public void testFindWord() {
        SimpleTask task1 = new SimpleTask(11, "Заниматься програмированием, читать книгу");

        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";

        EpicTask task2 = new EpicTask(13, subtasks);

        MeetingTask task3 = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);


        Task[] tasks = {task1, task2, task3};
        assertFalse(task1.matches("Изучить"));
        assertTrue(task2.matches("Изучить"));
        assertTrue(task3.matches("Изучить"));

        assertTrue(task1.matches("Заниматься"));
        assertFalse(task2.matches("Заниматься"));
        assertFalse(task3.matches("Заниматься"));

        assertFalse(task1.matches("Вытереть пыль"));
        assertFalse(task2.matches("Вытереть пыль"));
        assertFalse(task3.matches("Вытереть пыль"));

        assertTrue(task1.matches("читать"));
        assertTrue(task2.matches("читать"));
        assertTrue(task3.matches("читать"));

    }

    @Test
    public void searchSimpleTaskShouldBeTrue() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        assertTrue(task.matches("Заниматься"));
        assertTrue(task.matches("книгу"));
    }

    @Test
    public void searchEpicTaskShouldBeFalse() {
        EpicTask task = new EpicTask(11, "Заниматься програмированием, читать книгу");
        assertFalse(task.matches("11"));
        assertFalse(task.matches("Рыба"));
    }

    @Test
    public void searchEpicTaskShouldBeTrue() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";
        EpicTask task = new EpicTask(11, subtasks);
        assertTrue(task.matches("Вынести"));
        assertTrue(task.matches("книгу"));
    }

    @Test
    public void searchSimpleTasShouldBeFalse() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";
        SimpleTask task = new SimpleTask(11, subtasks);
        assertFalse(task.matches("11"));
        assertFalse(task.matches("Пылесос"));
    }

    @Test
    public void searchMeetingTaskShouldBeTrue() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        assertTrue(task.matches("доп."));
        assertTrue(task.matches("материалы"));
        assertTrue(task.matches("017"));
    }

    @Test
    public void searchMeetingTaskShouldBeFalse() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );
        assertFalse(task.matches("14"));
        assertFalse(task.matches("21:00"));
        assertFalse(task.matches("Вторник"));
    }

}