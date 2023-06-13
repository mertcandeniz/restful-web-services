package com.mertcandeniz.restfullwebservices.restfullwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {

        return new PersonV1("Mertcan Deniz");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2() {

        return new PersonV2(new Name("Mertcan", "Deniz"));
    }
    @GetMapping(value = "v1/person/param", params = "version=1")
    public PersonV1 personParamV1() {

        return new PersonV1("Mertcan Deniz");
    }
    @GetMapping(value = "v2/person/param", params = "version = 2")
    public PersonV2 personParamV2() {

        return new PersonV2(new Name("Mertcan", "Deniz"));
    }
}
