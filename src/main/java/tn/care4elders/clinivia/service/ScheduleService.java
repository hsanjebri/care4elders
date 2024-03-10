package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Schedule;

import java.util.List;

public interface ScheduleService {


    Schedule addSchedule(Schedule schedule);
    Schedule updateSchedule(Schedule schedule);

    List<Schedule> getAllSchedules();
    Schedule getScheduleById(long idSchedule);
    void deleteSchedule(long idSchedule);



}
