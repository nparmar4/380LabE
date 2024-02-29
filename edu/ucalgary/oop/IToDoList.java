package edu.ucalgary.oop;

import java.util.List;

interface IToDoList {

    void addTask(Task task);

    void completeTask(Task task);

    void deleteTask(Task task);

    void editTask(Task task, String newDescription);

    void undo();

    List<String> listTasks();
}

