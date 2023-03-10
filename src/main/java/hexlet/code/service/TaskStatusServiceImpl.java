package hexlet.code.service;

import hexlet.code.dto.TaskStatusDto;
import hexlet.code.exception.InvalidElementException;
import hexlet.code.model.TaskStatus;
import hexlet.code.repository.TaskStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TaskStatusServiceImpl implements TaskStatusService {

    private TaskStatusRepository taskStatusRepository;

    @Override
    public List<TaskStatus> getAllTaskStatuses() {
        return taskStatusRepository.findAll();
    }

    @Override
    public TaskStatus getTaskStatusById(long id) {
        return taskStatusRepository.findById(id)
                .orElseThrow(() -> InvalidElementException.invalidElement("Task status not found"));
    }

    @Override
    public TaskStatus createTaskStatus(final TaskStatusDto taskStatusDto) {
        final TaskStatus taskStatus = new TaskStatus();
        taskStatus.setName(taskStatusDto.getName());
        return taskStatusRepository.save(taskStatus);
    }

    @Override
    public TaskStatus updateTaskStatus(TaskStatusDto taskStatusDto, long id) {
        final TaskStatus taskStatusToUpdate = taskStatusRepository.findById(id)
                .orElseThrow(() -> InvalidElementException.invalidElement("Task status not found"));
        taskStatusToUpdate.setName(taskStatusDto.getName());
        return taskStatusRepository.save(taskStatusToUpdate);
    }

    @Override
    public void deleteTaskStatus(long id) {
        final TaskStatus taskStatus = taskStatusRepository.findById(id)
                .orElseThrow(() -> InvalidElementException.invalidElement("Task status not found"));
        taskStatusRepository.delete(taskStatus);
    }
}
