package test.Phoenix.task.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class Application extends BaseEntity
{
    private String title;

    private String address;

    private int quantity;

    private String phone;
}
