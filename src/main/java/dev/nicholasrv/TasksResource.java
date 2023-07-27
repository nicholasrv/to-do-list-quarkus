package dev.nicholasrv;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tasks")
public class TasksResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> taskList() {
        return Task.listAll();
    }
}
