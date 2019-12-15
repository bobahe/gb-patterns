package ru.bobahe.command;

import ru.bobahe.api.Command;
import ru.bobahe.api.TaskRepository;
import ru.bobahe.api.TerminalService;
import ru.bobahe.model.Task;
import ru.bobahe.service.TaskRepositoryAudit;
import ru.bobahe.service.TerminalServiceImpl;

public class CreateTaskCommand implements Command {

    private final TerminalService terminalService;

    private final TaskRepository taskRepository;

    public CreateTaskCommand() {
        this.terminalService = new TerminalServiceImpl();
        this.taskRepository = new TaskRepositoryAudit();
    }

    @Override
    public void execute() throws RuntimeException {
        final Task task = new Task();
        terminalService.println("TASK CREATION");
        terminalService.println("Enter task title: ");
        task.setTitle(terminalService.getLine());
        final Task savedTask = taskRepository.save(task);
        terminalService.println("Saved task id: " + savedTask.getId());
    }

    @Override
    public String getName() {
        return "task-create";
    }

}
