package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Schedule;
import tn.care4elders.clinivia.repository.ScheduleRepo;
import tn.care4elders.clinivia.service.ScheduleService;


import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleRepo scheduleRepo;


    @Override
    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepo.findAll();
    }

    @Override
    public Schedule getScheduleById(long IdSchedule) {
        return scheduleRepo.findById(IdSchedule).orElse(null);
    }

    @Override
    public void deleteSchedule(long IdSchedule) {
        scheduleRepo.deleteById(IdSchedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }
}
