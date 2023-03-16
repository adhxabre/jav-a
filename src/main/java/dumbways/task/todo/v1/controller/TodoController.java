package dumbways.task.todo.v1.controller;

import dumbways.task.todo.v1.entity.Todo;
import dumbways.task.todo.v1.repository.TodoRepository;
import dumbways.task.todo.v1.service.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public Iterable<Todo> findAll() {
        return todoService.findAll();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public Todo findOne(@PathVariable("id") long id) {
        return todoService.findOne(id);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Todo> findById(@PathVariable("id") long id,@RequestBody Todo todo) {
        Todo getTodo = todoRepository.findById(id);

        getTodo.setTitle(todo.getTitle());
        getTodo.setContent(todo.getContent());
        getTodo.setDone(todo.isDone());

        Todo updateTodo = todoRepository.save(getTodo);

        return ResponseEntity.ok().body(updateTodo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Todo> removeOne(@PathVariable("id") long id) {
        Todo getTodo = todoRepository.findById(id);
        todoService.removeOne(id);
        return ResponseEntity.ok().body(getTodo);
    }

}
