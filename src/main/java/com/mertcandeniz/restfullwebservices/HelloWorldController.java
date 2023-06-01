package com.mertcandeniz.restfullwebservices;

import com.mertcandeniz.restfullwebservices.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class HelloWorldController {

    //method : Sadece response almayı hedeflediğimiz için GET yeterli
    //url : /hello-world

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//    public String helloWorld() {
//        return "Hello World";
//    }
    @GetMapping (path = "/hello-world")
    public String helloWorld2() {
        return "Hello World";
    }

    //neden port'u 1 yapınca uygulama çalışmadı
    @GetMapping (path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping (path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
