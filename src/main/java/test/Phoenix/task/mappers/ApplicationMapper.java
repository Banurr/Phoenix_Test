package test.Phoenix.task.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import test.Phoenix.task.dtos.ApplicationCreate;
import test.Phoenix.task.dtos.ApplicationView;
import test.Phoenix.task.models.Application;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ApplicationMapper
{
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationView toView(Application entity);

    Application toEntity(ApplicationCreate dto);
}
