package com.redhat.quarkus.demo.todo;

import com.redhat.quarkus.demo.todo.beans.ToDo;
import java.lang.String;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/todos")
public interface TodosResource {
  /**
   * Gets a list of all `ToDo` entities.
   */
  @GET
  @Produces("application/json")
  List<ToDo> getToDos();

  /**
   * Creates a new instance of a `ToDo`.
   */
  @POST
  @Consumes("application/json")
  void createToDo(ToDo data);

  /**
   * Gets the details of a single instance of a `ToDo`.
   */
  @Path("/{todoId}")
  @GET
  @Produces("application/json")
  ToDo getToDo(@PathParam("todoId") String todoId);

  /**
   * Updates an existing `ToDo`.
   */
  @Path("/{todoId}")
  @PUT
  @Consumes("application/json")
  void updateToDo(@PathParam("todoId") String todoId, ToDo data);

  /**
   * Deletes an existing `ToDo`.
   */
  @Path("/{todoId}")
  @DELETE
  void deleteToDo(@PathParam("todoId") String todoId);
}
