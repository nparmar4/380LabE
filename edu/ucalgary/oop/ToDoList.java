package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        history.push(new ArrayList<>(tasks));

        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        history.push(new ArrayList<>(tasks));

        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                task.isCompleted();
                return;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        history.push(new ArrayList<>(tasks));

        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean markAsCompleted) {
        history.push(new ArrayList<>(tasks));

        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setTitle(newTitle);
                task.setCompleted(markAsCompleted);
                return;
            }
        }
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
