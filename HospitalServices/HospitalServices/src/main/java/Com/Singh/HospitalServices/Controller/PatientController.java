package Com.Singh.HospitalServices.Controller;


import Com.Singh.HospitalServices.Dto.PatientRequestDto;
import Com.Singh.HospitalServices.Dto.PatientResponseDto;
import Com.Singh.HospitalServices.Services.PatientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientServices patientServices;

    @PostMapping("/createPatients")
    public ResponseEntity<PatientResponseDto> createPatient(@RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto response = patientServices.createNewPatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
