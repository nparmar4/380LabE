package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class ToDoList implements IToDoList{

   private List<Task> tasks;
   private Stack<List<Task>> history;

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

   @Override
    public void editTask(Task task, String newDescription) {
        Task originalTask = tasks.get(tasks.indexOf(task));
        originalTask.setDescription(newDescription);
        history.push(new TaskOperation(OperationType.EDIT, originalTask));
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            TaskOperation lastOperation = history.pop();
            switch (lastOperation.getOperationType()) {
                case ADD:
                    tasks.remove(lastOperation.getTask());
                    break;
                case COMPLETE:
                    lastOperation.getTask().setCompleted(false);
                    break;
                case DELETE:
                    tasks.add(lastOperation.getTask());
                    break;
                case EDIT:
                    Task editedTask = lastOperation.getTask();
                    Task originalTask = tasks.get(tasks.indexOf(editedTask));
                    originalTask.setDescription(editedTask.getDescription());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public List<String> listTasks() {
        List<String> taskDescriptions = new ArrayList<>();
        for (Task task : tasks) {
            taskDescriptions.add(task.getDescription());
        }
        return taskDescriptions;
    }
}
