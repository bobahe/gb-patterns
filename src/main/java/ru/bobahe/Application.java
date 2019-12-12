package ru.bobahe;

import ru.bobahe.api.TaskRepository;
import ru.bobahe.model.Project;
import ru.bobahe.model.Task;
import ru.bobahe.service.TaskRepositoryAudit;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Application {

    public static void main(String[] args) {
        // homework 3
        final Project.Builder projectBuilder = Project.builder();
        final Project project = projectBuilder
                .setTitle("First project")
                .setDescription("Just first project")
                .setStartDate(ZonedDateTime.now())
                .setEndDate(LocalDate.parse("12.12.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")).atStartOfDay(ZoneId.of("+03")))
                .setTasks(null)
                .build();

        System.out.println(project.toString());

        // homework 4
        final Task task = new Task();
        task.setTitle("First task");
        final TaskRepository taskRepository = new TaskRepositoryAudit();
        taskRepository.save(task);
        taskRepository.delete(task);
    }

}
