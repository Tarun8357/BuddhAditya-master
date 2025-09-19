package com.buddhaditya.appointmentservice.services.interfaces;


import com.buddhaditya.appointmentservice.dto.AppointmentRequest;
import com.buddhaditya.appointmentservice.dto.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse bookAppointment(AppointmentRequest request);
    AppointmentResponse getAppointment(Long id);
    List<AppointmentResponse> getAppointmentsByPatient(Long patientId);
    List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);
    AppointmentResponse updateAppointment(Long id, AppointmentRequest request);
    void cancelAppointment(Long id);
}
