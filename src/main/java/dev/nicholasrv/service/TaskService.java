package dev.nicholasrv.service;

import dev.nicholasrv.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskService {

    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    public Task getTaskById(Long id) {
        return Task.findById(id);
    }

    @Transactional
    public void createTask(Task task) {
        task.persist();
    }

    @Transactional
    public void updateTask(Task task) {
        Task entity = Task.findById(task.id);
        if (entity != null) {
            entity.title = task.title;
            entity.description = task.description;
            entity.dueDate = task.dueDate;
            entity.done = task.done;
            entity.persist();
        }
    }

    @Transactional
    public void deleteTask(Long id) {
        Task.deleteById(id);
    }
}
