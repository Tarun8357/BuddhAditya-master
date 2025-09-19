package com.buddhaditya.appointmentservice.services.interfaces;

import com.buddhaditya.appointmentservice.dto.AppointmentRequest;
import com.buddhaditya.appointmentservice.dto.AppointmentResponse;
import com.buddhaditya.appointmentservice.entities.Appointment;

public interface AppointmentMapper {
    Appointment toEntity(AppointmentRequest request);
    AppointmentResponse toResponse(Appointment appointment);
    void updateEntity(Appointment appointment, AppointmentRequest request);
}
