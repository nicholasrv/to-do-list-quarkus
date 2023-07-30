package dev.nicholasrv.web;

import dev.nicholasrv.model.Tasks;
import dev.nicholasrv.service.TaskService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class ToDoListBean implements Serializable {

    @Inject
    private TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    private List<Tasks> tasks;
    private Tasks newTask;

    @PostConstruct
    public void init() {
        newTask = new Tasks();
    }

    /// MAIN METHODS

    public List<Tasks> getTasks() {
        if (tasks == null) {
            tasks = taskService.getAllTasks();
        }
        return tasks;
    }

    public String createTask() {
        taskService.createTask(newTask);
        tasks.add(newTask); // adds the new task to the list
        newTask = new Tasks(); // cleans up the form fields to create the new task
        return "todo-list?faces-redirect=true";
    }

    ///GETTERS N SETTERS

    public Tasks getNewTask() {
        return newTask;
    }

    public void setNewTask(Tasks newTask) {
        this.newTask = newTask;
    }

}
