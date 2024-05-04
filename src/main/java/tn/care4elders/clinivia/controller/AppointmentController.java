package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import tn.care4elders.clinivia.entity.Appointments;
import tn.care4elders.clinivia.service.serviceImpl.AppointmentServiceImpl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Appointments;
import tn.care4elders.clinivia.service.serviceImpl.AppointmentServiceImpl;
import java.util.List;
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Appointment")
@CrossOrigin("http://localhost:4200")


public class AppointmentController implements WebMvcConfigurer {


    AppointmentServiceImpl appointmentService;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
    @PostMapping("add")
    public Appointments addAppointment (@RequestBody Appointments appointments){
        return appointmentService.addAppointment(appointments);
    }


    @PutMapping("update/{id}")
    public Appointments updateAppointment(@PathVariable("id") long id, @RequestBody Appointments appointments) {
        appointments.setId(id);
        return appointmentService.updateAppointment(appointments);
    }


    @GetMapping("getAll")
    public List<Appointments> getAllAppointment (){
        return appointmentService.getAllAppointments();
    }
  /*  @GetMapping("getAllForDoctor")
    public List<Appointments> getAllAppointmentForDoctor (){
        return appointmentService.getAllAppointments(id);
    }
*/
    @GetMapping("get")
    public Appointments getAppointmentById (@RequestParam("id") long id){
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAppointment(@PathVariable("id") long id){
        appointmentService.deleteAppointment(id);
    }





}






