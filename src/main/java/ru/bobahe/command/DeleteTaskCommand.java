package ru.bobahe.command;

import ru.bobahe.api.Command;
import ru.bobahe.api.TaskRepository;
import ru.bobahe.api.TerminalService;
import ru.bobahe.model.Task;
import ru.bobahe.service.TaskRepositoryAudit;
import ru.bobahe.service.TerminalServiceImpl;

public class DeleteTaskCommand implements Command {

    private final TerminalService terminalService;

    private final TaskRepository taskRepository;

    public DeleteTaskCommand() {
        this.terminalService = new TerminalServiceImpl();
        this.taskRepository = new TaskRepositoryAudit();
    }

    @Override
    public void execute() throws RuntimeException {
        final Task task = new Task();
        terminalService.println("TASK DELETION");
        terminalService.println("Enter task id: ");
        task.setId(terminalService.getLine());
        taskRepository.delete(task);
    }

    @Override
    public String getName() {
        return "task-delete";
    }

}
