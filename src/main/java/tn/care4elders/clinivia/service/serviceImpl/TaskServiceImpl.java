package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Task;
import tn.care4elders.clinivia.repository.TaskRepository;
import tn.care4elders.clinivia.service.TaskService;
import tn.care4elders.clinivia.service.TwillioService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TaskServiceImpl implements TaskService {


    @Autowired
      TaskRepository taskRepository;
    @Autowired
    TwillioService twillioService;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> findTasksDueTomorrowAndNotDone() {
        // Calculate tomorrow's date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        // Find tasks due tomorrow and not done
        return taskRepository.findByDueDateBetweenAndDoneFalse(tomorrow, tomorrow);
    }

    // Scheduled job to run at 12:00 AM every day
  @Scheduled(cron = "0 0 0 * * *")
  // @Scheduled(cron = "*/30 * * * * *")
    public void remindTasksDueTomorrow() {
        List<Task> tasks = findTasksDueTomorrowAndNotDone();
        if (!tasks.isEmpty()) {
            System.out.println("Reminder: You have tasks due tomorrow that are not done:");
            for (Task task : tasks) {
                System.out.println(task.getTitle());
            }
            // Make voice call for reminder
            String from = "+18583337752";
            String to = "+21623671593";
            twillioService.makeCall(from, to);
        }
    }

    @Override
    public List<Task> findTasksByPatientId(Long patientId) {
        return taskRepository.findTasksByPatientId(patientId);
    }
}
