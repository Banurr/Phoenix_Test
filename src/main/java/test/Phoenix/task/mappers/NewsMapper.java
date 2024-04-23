package test.Phoenix.task.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import test.Phoenix.task.dtos.NewsView;
import test.Phoenix.task.models.News;

@Mapper(builder = @Builder(disableBuilder = true))
public interface NewsMapper
{
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsView toView(News entity);
}
