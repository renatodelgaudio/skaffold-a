
package com.example.skaffold.componenta;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! This is a skaffold PoC where docker container has been built by using Jib approach!";
    private final AtomicLong counter = new AtomicLong();
  
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
      return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

}