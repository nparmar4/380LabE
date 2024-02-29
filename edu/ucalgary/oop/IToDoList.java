package edu.ucalgary.oop;

import java.util.Objects;

interface IToDoList {

    private List<Task> tasks;
    private Stack<TaskOperation> history;

    public IToDoList() {
    }

    public void addTask(Task task) {
    }

    public void completeTask(Task task) {
    }

    public void deleteTask(Task task) {
    }

    public void editTask(Task task, String newDescription) {
    }

    public void undo() {
  
    }
    
    public List<String> listTasks() {
    }
}