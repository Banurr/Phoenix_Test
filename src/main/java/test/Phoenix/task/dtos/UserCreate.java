package test.Phoenix.task.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreate
{
    private String email;

    private String password;

    private String rePassword;

    private String fullName;

    private String avatar;
}
