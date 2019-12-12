package ru.bobahe.api;

import ru.bobahe.model.Task;

public interface TaskRepository {

    Task save(Task task);
    void delete(Task task);

}
