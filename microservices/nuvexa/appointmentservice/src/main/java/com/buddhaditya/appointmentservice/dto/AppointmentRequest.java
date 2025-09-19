package com.buddhaditya.appointmentservice.dto;

import com.buddhaditya.appointmentservice.dto.enums.AppointmentType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequest {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentTime;
    private String reason;
    private String clinicLocation;
    private AppointmentType appointmentType;
    private Integer durationMinutes;
    private String notes;
    private String createdBy;
}
