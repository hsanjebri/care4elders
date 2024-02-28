package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import tn.care4elders.clinivia.entity.Appointment;
import tn.care4elders.clinivia.service.AppointmentServiceImpl;


import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Appointment")
public class AppointmentController {


    AppointmentServiceImpl appointmentService;


    @PostMapping("add")
    public Appointment addAppointment (@RequestBody Appointment appointment){
        return appointmentService.addAppointment(appointment);
    }


    @PutMapping("update/{idAppointment}")
    public Appointment updateAppointment(@PathVariable("idAppointment") long idAppointment, @RequestBody Appointment appointment) {
        appointment.setIdAppointment(idAppointment);
        return appointmentService.updateAppointment(appointment);
    }


    @GetMapping("getAll")
    public List<Appointment> getAllAppointment (){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("get")
    public Appointment getAppointmentById ( @RequestParam("IdAppointment") long IdAppointment){
        return appointmentService.getAppointmentById(IdAppointment);
    }

    @DeleteMapping("delete/{idAppointment}")
    public void deleteAppointment(@PathVariable("idAppointment") long IdAppointment){
        appointmentService.deleteAppointment(IdAppointment);
    }





}






