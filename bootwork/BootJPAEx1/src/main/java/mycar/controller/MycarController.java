package mycar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MycarController {

    @GetMapping("/")
    public String home() {
        return "redirect:./mycar/list";
    }

    @GetMapping("/mycar/list")
    public String list() {
        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/form")
    public String form() {
        return "mycar/mycarform";
    }
}
