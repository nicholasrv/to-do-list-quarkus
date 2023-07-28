package dev.nicholasrv.web;

import dev.nicholasrv.model.Task;
import dev.nicholasrv.service.TaskService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ToDoListBean implements Serializable {

    @Inject
    private TaskService taskService;

    private List<Task> tasks;

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = taskService.getAllTasks();
        }
        return tasks;
    }

    public void createTask(Task newTask) {
        taskService.createTask(newTask);
        // Reset the list to force a refresh and display the new task
        tasks = null;
    }
}
