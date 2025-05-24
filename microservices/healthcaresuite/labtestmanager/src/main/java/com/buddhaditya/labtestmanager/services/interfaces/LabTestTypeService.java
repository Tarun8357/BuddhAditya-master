package com.buddhaditya.labtestmanager.services.interfaces;

import com.buddhaditya.labtestmanager.dto.LabTestTypeRequest;
import com.buddhaditya.labtestmanager.dto.LabTestTypeResponse;
import java.util.List;

public interface LabTestTypeService {
    LabTestTypeResponse createLabTestType(LabTestTypeRequest request);
    LabTestTypeResponse getLabTestTypeById(Long id);
    List<LabTestTypeResponse> getAllLabTestTypes();
    LabTestTypeResponse updateLabTestType(Long id, LabTestTypeRequest request);
    void deleteLabTestType(Long id);
}
