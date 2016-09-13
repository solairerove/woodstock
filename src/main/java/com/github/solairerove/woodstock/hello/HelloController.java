package com.github.solairerove.woodstock.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krivitski-no on 9/13/16.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Controller!!!";
    }
}
