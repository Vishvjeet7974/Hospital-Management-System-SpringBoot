package Com.Singh.HospitalServices.Controller;


import Com.Singh.HospitalServices.Dto.AssignInsuranceRequestDto;
import Com.Singh.HospitalServices.Dto.InsuranceRequestDto;
import Com.Singh.HospitalServices.Dto.InsuranceResponseDto;
import Com.Singh.HospitalServices.Dto.PatientResponseDto;
import Com.Singh.HospitalServices.Entity.Insurance;
import Com.Singh.HospitalServices.Entity.Patient;
import Com.Singh.HospitalServices.Repository.InsuranceRepository;
import Com.Singh.HospitalServices.Services.InsuranceServices;
import Com.Singh.HospitalServices.Services.PatientServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceServices insuranceServices;

    private final ModelMapper modelMapper;


    @PostMapping("/assign-insurance")
    public ResponseEntity<PatientResponseDto> assignInsuranceToPatient(@RequestBody AssignInsuranceRequestDto requestDto) {
        Insurance insurance = modelMapper.map(requestDto.getInsurance(), Insurance.class);

        Patient updatedPatient = insuranceServices.assignInsuranceToPatient(insurance, requestDto.getPatientId());

        PatientResponseDto responseDto = modelMapper.map(updatedPatient, PatientResponseDto.class);

        return ResponseEntity.ok(responseDto);

    }


}
