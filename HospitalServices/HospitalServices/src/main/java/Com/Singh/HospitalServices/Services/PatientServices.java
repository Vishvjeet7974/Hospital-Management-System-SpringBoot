package Com.Singh.HospitalServices.Services;

import Com.Singh.HospitalServices.Dto.PatientRequestDto;
import Com.Singh.HospitalServices.Dto.PatientResponseDto;

import java.util.List;

public interface PatientServices {

    PatientResponseDto createNewPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto getPatientById(Long patientId);

    List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize);
}
