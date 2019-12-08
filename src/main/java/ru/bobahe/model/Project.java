package ru.bobahe.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String title;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<Task> tasks;

    private Project() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public static Builder builder() {
        return new Project().new Builder();
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStartDate(final ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public void addTask(final Task task) {
        if (task == null) return;
        if (tasks == null) return;
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", tasks=" + tasks +
                '}';
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTitle(final String title) {
            if (title == null) throw new RuntimeException("Title can not be null.");
            Project.this.title = title;
            return this;
        }

        public Builder setDescription(final String description) {
            Project.this.description = description;
            return this;
        }

        public Builder setStartDate(final ZonedDateTime startDate) {
            Project.this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(final ZonedDateTime endDate) {
            Project.this.endDate = endDate;
            return this;
        }

        public Builder setTasks(final List<Task> tasks) {
            if (tasks == null) return this;
            Project.this.tasks = new ArrayList<>(tasks);
            return this;
        }

        public Project build() {
            if (Project.this.title == null) throw new RuntimeException("Title can not be null.");
            if (Project.this.startDate == null) Project.this.startDate = ZonedDateTime.now();
            if (tasks == null) Project.this.tasks = new ArrayList<>();
            return Project.this;
        }

    }

}
