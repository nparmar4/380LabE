package edu.ucalgary.oop;

import java.util.Objects;

interface ToDoList {

   private List<Task> tasks;
   private Stack<TaskOperation> history;

   public ToDoList() {
       this.tasks = new ArrayList<>();
       this.history = new Stack<>();
   }

   @Override
   public void addTask(Task task) {
       tasks.add(task);
       history.push(new TaskOperation(OperationType.ADD, task));
   }

   @Override
   public void completeTask(Task task) {
       task.setCompleted(true);
       history.push(new TaskOperation(OperationType.COMPLETE, task));
   }

   @Override
   public void deleteTask(Task task) {
       tasks.remove(task);
       history.push(new TaskOperation(OperationType.DELETE, task));
   }

   public void editing() {
       
   }

   public void undoing() {

   }

   public void listing_tasks() {
       
   }
}