package com.buddhaditya.labtestmanager.mappers;


import com.buddhaditya.labtestmanager.dto.LabTestTypeRequest;
import com.buddhaditya.labtestmanager.dto.LabTestTypeResponse;
import com.buddhaditya.labtestmanager.entities.LabTestType;

public class LabTestTypeMapper {

    public static LabTestType toEntity(LabTestTypeRequest labTestTypeRequest) {
        LabTestType entity = new LabTestType();
        entity.setName(labTestTypeRequest.getName());
        entity.setDescription(labTestTypeRequest.getDescription());
        entity.setSampleType(labTestTypeRequest.getSampleType());
        entity.setPrice(labTestTypeRequest.getPrice());
        entity.setPreparationInstructions(labTestTypeRequest.getPreparationInstructions());
        entity.setDepartment(labTestTypeRequest.getDepartment());
        entity.setActive(labTestTypeRequest.getActive());
        return entity;
    }


    public static LabTestTypeResponse toResponse(LabTestType entity) {
        return new LabTestTypeResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getSampleType(),
                entity.getPrice(),
                entity.getPreparationInstructions(),
                entity.getDepartment(),
                entity.getActive()
        );
    }
}
