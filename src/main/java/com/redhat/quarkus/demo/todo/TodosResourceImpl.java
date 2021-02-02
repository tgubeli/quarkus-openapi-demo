package com.redhat.quarkus.demo.todo;

import com.redhat.quarkus.demo.todo.beans.ToDo;
import java.util.List;
import javax.enterprise.context.RequestScoped;


@RequestScoped
public class TodosResourceImpl implements TodosResource {

  @Override
  public List<ToDo> getToDos() {
    return ToDo.listAll();
  }

  @Override
  public void createToDo(ToDo data) {
    ToDo.persist(data);
  }

  @Override
  public ToDo getToDo(String todoId) {
    return ToDo.findById(todoId);
  }

  @Override
  public void updateToDo(String todoId, ToDo data) {
    ToDo existing = ToDo.findById(todoId);
    existing.setTitle(data.getTitle());
    existing.setDescription(data.getDescription());
    existing.setDueDate(data.getDueDate());
    existing.setComplete(data.getComplete());
    existing.persist();
  }

  @Override
  public void deleteToDo(String todoId) {
    ToDo.findById(todoId).delete();
  }
}