package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the task management system.
 * A task stores an ID, description, and status.
 *
 * Author: Dakarri Jenkins
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given ID and description.
     * The default status is OPEN.
     *
     * @param taskId the unique task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     * Valid status values are OPEN, IN_PROGRESS, and COMPLETE.
     * Any other value sets the status to UNKNOWN.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task in the format:
     * taskId description [status]
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
