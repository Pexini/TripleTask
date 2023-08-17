package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void searchAndNotFindSimpleTask() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        assertEquals("задача не найдена", task.search("пушкин"));
    }

    @Test
    public void searchAndFindSimpleTask() {
        SimpleTask task = new SimpleTask(11, "Заниматься програмированием, читать книгу");
        assertEquals("Заниматься програмированием, читать книгу", task.search("читать"));
    }

    @Test
    public void searchAndNotFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";
        EpicTask task = new EpicTask(11, subtasks);
        assertEquals("задача не найдена", task.search("пушкин"));
    }

    @Test
    public void searchAndFindEpicTask() {
        String subtasks = "Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу";
        EpicTask task = new EpicTask(11, subtasks);
        assertEquals("Изучить кулинарию, Вынести мусор, Купить продукты, читать книгу", task.search("кулинарию"));
    }

    @Test
    public void searchAndNotFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );

        assertEquals("задача не найдена", task.search("пушкин"));
    }

    @Test
    public void searchAndFindMeetingTask() {
        MeetingTask task = new MeetingTask(
                14,
                "Изучить доп. литературу, читать материалы",
                "017",
                "21:00"
        );

        assertEquals("Изучить доп. литературу, читать материалы", task.search("материалы"));
    }
}