package dev.nicholasrv.rest;

import dev.nicholasrv.model.Tasks;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import dev.nicholasrv.service.TaskService;
import jakarta.ws.rs.core.Response;


@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Tasks> taskList() {
        return taskService.getAllTasks();
    }


    @POST
    public Response createTask(Tasks task) {
        taskService.createTask(task);
        // In RESTEasy we can use the Response class as a type for returning the status and the saved entity.
        // It would be something pretty similar to Spring's ResponseEntity type.
        return Response.ok(task).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") Long id, Tasks task) {
        task.id = id;
        boolean updateSuccess = taskService.updateTask(task);

        if (updateSuccess) {
            return Response.ok(task).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Entity with ID " + id + " was not found.")
                    .build();

        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.deleteTask(id);
    }
}

