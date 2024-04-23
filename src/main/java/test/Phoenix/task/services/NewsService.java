package test.Phoenix.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Phoenix.task.dtos.NewsView;
import test.Phoenix.task.mappers.NewsMapper;
import test.Phoenix.task.models.News;
import test.Phoenix.task.repositories.NewsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService
{
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsView> allNews()
    {
        List<News> list = newsRepository.findAll();
        return list.stream().map(NewsMapper.INSTANCE::toView).collect(Collectors.toList());
    }
}
