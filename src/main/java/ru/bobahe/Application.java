package ru.bobahe;

import ru.bobahe.model.Project;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Application {

    public static void main(String[] args) {
        final Project.Builder projectBuilder = Project.builder();
        final Project project = projectBuilder
                .setTitle("First project")
                .setDescription("Just first project")
                .setStartDate(ZonedDateTime.now())
                .setEndDate(LocalDate.parse("12.12.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")).atStartOfDay(ZoneId.of("+03")))
                .setTasks(null)
                .build();

        System.out.println(project.toString());
    }

}
