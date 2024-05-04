package tn.care4elders.clinivia.service.serviceImpl;


import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import tn.care4elders.clinivia.entity.Appointments;
import tn.care4elders.clinivia.repository.AppointmentRepo;
import tn.care4elders.clinivia.service.AppointmentService;


import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AppointmentServiceImpl implements AppointmentService {


    AppointmentRepo appointmentRepo;

    @Override
    public Appointments addAppointment (Appointments appointments)
    {
        return appointmentRepo.save(appointments);
    }

    @Override
    public List<Appointments> getAllAppointments() {

        return (List<Appointments>) appointmentRepo.findAll();
    }

    @Override
    public Appointments getAppointmentById(long id) {


        return appointmentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAppointment(long id)
    {
        appointmentRepo.deleteById(id);
    }


    @Override
    public Appointments updateAppointment(Appointments appointments)

    {
        return appointmentRepo.save(appointments);
    }

    /*    @Override
        public List<Appointments> getAllAppointmentForDoctor(long id) {

            return (List<Appointments>) appointmentRepo.findby();
        }*/


}
