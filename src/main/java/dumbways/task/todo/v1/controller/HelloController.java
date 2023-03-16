package dumbways.task.todo.v1.controller;

import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "Hello World!";
    }

}
