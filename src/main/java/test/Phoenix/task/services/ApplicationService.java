package test.Phoenix.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Phoenix.task.dtos.ApplicationCreate;
import test.Phoenix.task.dtos.ApplicationView;
import test.Phoenix.task.exceptions.ApplicatonNotFoundException;
import test.Phoenix.task.mappers.ApplicationMapper;
import test.Phoenix.task.models.Application;
import test.Phoenix.task.repositories.ApplicationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService
{
    @Autowired
    private ApplicationRepository applicationRepository;

    public void addApplication(ApplicationCreate applicatonCreate)
    {
        Application application = ApplicationMapper.INSTANCE.toEntity(applicatonCreate);
        application.setCreated_at(LocalDateTime.now());
        applicationRepository.save(application);
    }

    public ApplicationView getApplicaton(Long id)
    {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicatonNotFoundException("Application was not found!"));
        return ApplicationMapper.INSTANCE.toView(application);
    }

    public List<ApplicationView> allApplications()
    {
        List<Application> list = applicationRepository.findAll();
        return list.stream()
                .map(ApplicationMapper.INSTANCE::toView)
                .collect(Collectors.toList());
    }

}
