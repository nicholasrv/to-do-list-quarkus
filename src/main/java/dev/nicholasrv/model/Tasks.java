package dev.nicholasrv.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Tasks extends PanacheEntity {
    public String title;
    public String description;
    public Date dueDate;
    public boolean done;

}
