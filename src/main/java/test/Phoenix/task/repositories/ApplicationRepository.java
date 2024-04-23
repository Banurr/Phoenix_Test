package test.Phoenix.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.Phoenix.task.models.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>
{

}
