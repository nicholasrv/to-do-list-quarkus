package dev.nicholasrv;

import java.time.LocalDate;

public class Task extends PanacheEntity {
    public String title;
    public String description;
    public LocalDate dueDate;
    public UserEntity userEntity;

}
