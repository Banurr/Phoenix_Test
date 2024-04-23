package test.Phoenix.task.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News extends BaseEntity
{
    private String title;

    private String content;

    private String author;

    private String category;
}
