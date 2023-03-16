package dumbways.task.todo.v1.repository;

import dumbways.task.todo.v1.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo findById(long id);

}
