package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Request worked!";
    }
}
