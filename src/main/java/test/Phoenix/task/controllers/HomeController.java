package test.Phoenix.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/error")
    public String not_auth()
    {
        return "error";
    }
}
