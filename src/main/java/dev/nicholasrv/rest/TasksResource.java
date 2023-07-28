package dev.nicholasrv.rest;

import dev.nicholasrv.model.Task;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import dev.nicholasrv.model.Task;
import dev.nicholasrv.service.TaskService;


@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TasksResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> taskList() {
        return taskService.getAllTasks();
    }

    @POST
    public void createTask(Task task) {
        taskService.createTask(task);
    }

    @PUT
    @Path("/{id}")
    public void updateTask(@PathParam("id") Long id, Task task) {
        task.id = id;
        taskService.updateTask(task);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.deleteTask(id);
    }
}

