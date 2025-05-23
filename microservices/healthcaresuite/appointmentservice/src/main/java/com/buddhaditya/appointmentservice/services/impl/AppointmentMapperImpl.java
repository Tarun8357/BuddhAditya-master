package com.buddhaditya.appointmentservice.services.impl;


import com.buddhaditya.appointmentservice.dto.AppointmentRequest;
import com.buddhaditya.appointmentservice.dto.AppointmentResponse;
import com.buddhaditya.appointmentservice.entities.Appointment;
import com.buddhaditya.appointmentservice.services.interfaces.AppointmentMapper;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public Appointment toEntity(AppointmentRequest request) {
        if (request == null) {
            return null;
        }

        Appointment appointment = new Appointment();
        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setReason(request.getReason());
        appointment.setClinicLocation(request.getClinicLocation());
        appointment.setAppointmentType(request.getAppointmentType());
        appointment.setDurationMinutes(request.getDurationMinutes());
        appointment.setNotes(request.getNotes());
        appointment.setCreatedBy(request.getCreatedBy());
        return appointment;
    }

    @Override
    public AppointmentResponse toResponse(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setPatientId(appointment.getPatientId());
        response.setDoctorId(appointment.getDoctorId());
        response.setAppointmentTime(appointment.getAppointmentTime());
        response.setReason(appointment.getReason());
        response.setClinicLocation(appointment.getClinicLocation());
        response.setAppointmentType(appointment.getAppointmentType());
        response.setDurationMinutes(appointment.getDurationMinutes());
        response.setNotes(appointment.getNotes());
        response.setCreatedBy(appointment.getCreatedBy());
        response.setCreatedAt(appointment.getCreatedAt());
        return response;
    }

    @Override
    public void updateEntity(Appointment appointment, AppointmentRequest request) {
        if (appointment == null || request == null) return;

        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setReason(request.getReason());
        appointment.setClinicLocation(request.getClinicLocation());
        appointment.setAppointmentType(request.getAppointmentType());
        appointment.setDurationMinutes(request.getDurationMinutes());
        appointment.setNotes(request.getNotes());
        appointment.setCreatedBy(request.getCreatedBy());
    }
}
