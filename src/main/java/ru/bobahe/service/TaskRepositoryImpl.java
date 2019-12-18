package ru.bobahe.service;

import ru.bobahe.api.TaskRepository;
import ru.bobahe.model.Task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepositoryImpl implements TaskRepository {

    private Map<String, Task> storage;

    public TaskRepositoryImpl() {
        this.storage = new LinkedHashMap<>();
    }

    @Override
    public Task save(final Task task) {
        if (task == null) throw new IllegalArgumentException("Нельзя сохранить null.");
        final String id = UUID.randomUUID().toString();
        task.setId(id);
        storage.put(id, task);
        return task;
    }

    @Override
    public void delete(final Task task) {
        if (task == null) throw new IllegalArgumentException("Нельзя удалить null.");
        if (task.getId() == null) return;
        storage.remove(task.getId());
    }

    @Override
    public Task getById(final String id) {
        if (id == null) throw new IllegalArgumentException("Неверно указан ключ.");
        return storage.get(id);
    }

}
