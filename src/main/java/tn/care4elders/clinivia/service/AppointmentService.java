package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Appointment;

import java.util.List;

public interface AppointmentService {


    Appointment addAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(long IdAppointment);

    void deleteAppointment(long IdAppointment);

}
