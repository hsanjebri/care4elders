package tn.care4elders.clinivia.service;


import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.care4elders.clinivia.entity.Appointment;
import tn.care4elders.clinivia.repository.AppointmentRepo;


import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AppointmentServiceImpl implements AppointmentService {


    AppointmentRepo appointmentRepo;

    @Override
    public Appointment addAppointment (Appointment appointment)
    {
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {

        return (List<Appointment>) appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentById(long idAppointment) {


        return appointmentRepo.findById(idAppointment).orElse(null);
    }

    @Override
    public void deleteAppointment(long idAppointment)
    {
        appointmentRepo.deleteById(idAppointment);
    }


    @Override
    public Appointment updateAppointment(Appointment appointment)

    {
        return appointmentRepo.save(appointment);
    }




}
