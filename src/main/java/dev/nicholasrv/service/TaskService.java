package dev.nicholasrv.service;

import dev.nicholasrv.model.Tasks;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class TaskService {

    public List<Tasks> getAllTasks() {
        return Tasks.listAll();
    }

    public Tasks getTaskById(Long id) {
        return Tasks.findById(id);
    }

    @Transactional
    public void createTask(Tasks task) {
        task.persist();
    }


    @Transactional
    public boolean updateTask(Tasks task) {
        Tasks entity = Tasks.findById(task.id);
        if (entity == null) {
            return false;
        }

        entity.title = task.title;
        entity.description = task.description;
        entity.dueDate = task.dueDate;
        entity.done = task.done;
        entity.persistAndFlush();

        return true;
    }

    @Transactional
    public void deleteTask(Long id) {
        Tasks.deleteById(id);
    }
}
