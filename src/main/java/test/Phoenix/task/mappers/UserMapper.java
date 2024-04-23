package test.Phoenix.task.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import test.Phoenix.task.dtos.UserCreate;
import test.Phoenix.task.dtos.UserLogin;
import test.Phoenix.task.dtos.UserView;
import test.Phoenix.task.models.User;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserView toView(User entity);

    User toEntity(UserCreate dto);

    User toEntity(UserLogin dto);
}
