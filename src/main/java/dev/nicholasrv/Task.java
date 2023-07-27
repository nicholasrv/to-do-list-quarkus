package dev.nicholasrv;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Task extends PanacheEntity {
    public String title;
    public String description;
    public LocalDate dueDate;
    public boolean done;

}
