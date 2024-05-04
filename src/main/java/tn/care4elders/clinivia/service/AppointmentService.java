package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Appointments;

import java.util.List;

public interface AppointmentService {


    Appointments addAppointment(Appointments appointments);


    Appointments updateAppointment(Appointments appointments);
    List<Appointments> getAllAppointments();

    Appointments getAppointmentById(long id);

    void deleteAppointment(long id);

    //List<Appointments> getAllAppointmentForDoctor(long id);
}
