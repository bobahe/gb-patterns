package ru.bobahe;

import ru.bobahe.api.Command;
import ru.bobahe.api.TaskRepository;
import ru.bobahe.api.TerminalService;
import ru.bobahe.command.CreateTaskCommand;
import ru.bobahe.command.DeleteTaskCommand;
import ru.bobahe.model.Project;
import ru.bobahe.model.Task;
import ru.bobahe.service.TaskRepositoryAudit;
import ru.bobahe.service.TerminalServiceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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

        //homework 5
        process();
    }

    private static void process() {
        final TerminalService terminalService = new TerminalServiceImpl();
        String command = terminalService.getLine();

        while (!"exit".equals(command)) {
            if (command.isEmpty()) {
                command = terminalService.getLine();
                continue;
            }
            invokeCommand(command);
            command = terminalService.getLine();
        }
    }

    private static void invokeCommand(String commandName) {
        final TerminalService terminalService = new TerminalServiceImpl();
        final List<Command> commands = Arrays.asList(new CreateTaskCommand(), new DeleteTaskCommand());
        final Command command = commands.stream().filter(c -> c.getName().equals(commandName)).findFirst().orElse(null);

        try {
            if (command == null) throw new RuntimeException("There is no such command");
            command.execute();
        } catch (Exception e) {
            terminalService.printerr(e.getMessage());
        }
    }

}
