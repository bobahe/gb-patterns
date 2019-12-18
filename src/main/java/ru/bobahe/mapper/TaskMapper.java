package ru.bobahe.mapper;

import ru.bobahe.api.TaskRepository;
import ru.bobahe.model.Task;
import ru.bobahe.service.TaskRepositoryAudit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskMapper {

    private final TaskRepository taskRepository;
    private final Map<String, Task> cache;

    public TaskMapper() {
        this.taskRepository = new TaskRepositoryAudit();
        this.cache = new ConcurrentHashMap<>();
    }

    public Task getById(final String id) {
        if (cache.containsKey(id)) return cache.get(id);
        return taskRepository.getById(id);
    }

    public Task save(final Task task) {
        final Task savedTask = taskRepository.save(task);
        cache.put(savedTask.getId(), savedTask);
        return savedTask;
    }

    public void delete(final Task task) {
        cache.remove(task.getId());
        taskRepository.delete(task);
    }

}
