package test.Phoenix.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Phoenix.task.services.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsController
{
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<?> allNews()
    {
        return ResponseEntity.ok(newsService.allNews());
    }
}
