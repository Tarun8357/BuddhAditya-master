package com.buddhaditya.labtestmanager.services.interfaces;

import com.buddhaditya.labtestmanager.entities.LabTestStatus;
import java.util.List;

public interface LabTestStatusService {
    List<LabTestStatus> getAllStatuses();
}
