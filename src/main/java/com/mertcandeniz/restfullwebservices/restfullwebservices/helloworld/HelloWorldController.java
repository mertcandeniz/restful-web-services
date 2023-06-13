package com.mertcandeniz.restfullwebservices.restfullwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@Controller
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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
    @GetMapping (path = "/hello-world-inter")
    public String helloWorldInternationalization() {
        return messageSource.getMessage("good.morning.message", null,"Default Message", LocaleContextHolder.getLocale());
    }
}
