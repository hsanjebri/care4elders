package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Schedule;

import tn.care4elders.clinivia.service.serviceImpl.ScheduleServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/schedule")
public class ScheduleController {

    ScheduleServiceImpl scheduleService;

    @PostMapping("add")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }

    @PutMapping("update/{IdSchedule}")
    public Schedule updateSchedule(@PathVariable("IdSchedule") Long IdSchedule , @RequestBody Schedule schedule) {

        schedule.setIdSchedule(IdSchedule);

        return scheduleService.updateSchedule(schedule);
    }


    @GetMapping("getAll")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("getById")
    public Schedule getScheduleById(@RequestParam("IdSchedule") long IdSchedule) {
        return scheduleService.getScheduleById(IdSchedule);
    }

    @DeleteMapping("delete/{IdSchedule}")
    public void deleteSchedule(@PathVariable("IdSchedule") long IdSchedule) {
        scheduleService.deleteSchedule(IdSchedule);
    }
}
