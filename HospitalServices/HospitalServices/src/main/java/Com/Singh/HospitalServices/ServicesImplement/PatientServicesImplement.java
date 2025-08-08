package Com.Singh.HospitalServices.ServicesImplement;

import Com.Singh.HospitalServices.Dto.InsuranceResponseDto;
import Com.Singh.HospitalServices.Dto.PatientRequestDto;
import Com.Singh.HospitalServices.Dto.PatientResponseDto;
import Com.Singh.HospitalServices.Entity.Insurance;
import Com.Singh.HospitalServices.Entity.Patient;
import Com.Singh.HospitalServices.Entity.User;
import Com.Singh.HospitalServices.Repository.InsuranceRepository;
import Com.Singh.HospitalServices.Repository.PatientRepository;
import Com.Singh.HospitalServices.Repository.UserRepository;
import Com.Singh.HospitalServices.Services.PatientServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientServicesImplement implements PatientServices {


    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public PatientResponseDto createNewPatient(PatientRequestDto patientRequestDto) {

        User user = userRepository.findById(patientRequestDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id"));


        Patient patient = Patient.builder()
                .name(patientRequestDto.getName())
                .email(patientRequestDto.getEmail())
                .birthDate(patientRequestDto.getBirthDate())
                .gender(patientRequestDto.getGender())
                .bloodGroup(patientRequestDto.getBloodGroup())
                .user(user)
                .build();

        if (patientRequestDto.getInsurance() != null) {
            Insurance insurance = modelMapper.map(patientRequestDto.getInsurance(), Insurance.class);
            insurance = insuranceRepository.save(insurance);
            patient.setInsurance(insurance);
        }


        patient = patientRepository.save(patient);

        PatientResponseDto responseDto = modelMapper.map(patient, PatientResponseDto.class);

        if (patient.getInsurance() != null) {
            InsuranceResponseDto insuranceResponseDto = modelMapper.map(patient.getInsurance(), InsuranceResponseDto.class);
            responseDto.setInsurance(insuranceResponseDto);
        }

        return responseDto;

    }

    @Override
    public PatientResponseDto getPatientById(Long patientId) {
        return null;
    }

    @Override
    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
        return List.of();
    }
}
