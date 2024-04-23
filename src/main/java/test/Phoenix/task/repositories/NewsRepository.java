package test.Phoenix.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.Phoenix.task.models.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>
{

}
