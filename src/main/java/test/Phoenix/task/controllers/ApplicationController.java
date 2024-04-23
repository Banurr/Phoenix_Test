package test.Phoenix.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.Phoenix.task.dtos.ApplicationCreate;
import test.Phoenix.task.dtos.ApplicationView;
import test.Phoenix.task.exceptions.ApplicatonNotFoundException;
import test.Phoenix.task.services.ApplicationService;


@RestController
@RequestMapping(value = "/applications")
public class ApplicationController
{
    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> createApplication(@RequestBody ApplicationCreate applicationCreate)
    {
        try
        {
            applicationService.addApplication(applicationCreate);
            return ResponseEntity.ok("Application created successfully");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Application creation failed");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplication(@PathVariable Long id)
    {
        try
        {
            ApplicationView applicationView = applicationService.getApplicaton(id);
            return ResponseEntity.ok(applicationView);
        }
        catch (ApplicatonNotFoundException e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Application was not found");
        }
    }

    @GetMapping
    public ResponseEntity<?> allApplications()
    {
        return ResponseEntity.ok(applicationService.allApplications());
    }

}
