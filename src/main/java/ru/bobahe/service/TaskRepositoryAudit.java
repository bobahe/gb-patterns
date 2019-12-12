package ru.bobahe.service;

import ru.bobahe.api.TaskRepository;
import ru.bobahe.model.Task;

public class TaskRepositoryAudit implements TaskRepository {

    private static final String SAVE_MSG = "Сохранение ";
    private static final String REMOVE_MSG = "Удаление ";

    private TaskRepository original;

    public TaskRepositoryAudit() {
        this.original = new TaskRepositoryImpl();
    }

    @Override
    public Task save(final Task task) {
        final Task savedTask = original.save(task);
        auditOperation(SAVE_MSG, savedTask.getId());
        return savedTask;
    }

    @Override
    public void delete(final Task task) {
        original.delete(task);
        auditOperation(REMOVE_MSG, task.getId());
    }

    private void auditOperation(final String operation, final String objectId) {
        System.out.println("--> " + operation + " задачи с id: " + objectId);
    }

}
