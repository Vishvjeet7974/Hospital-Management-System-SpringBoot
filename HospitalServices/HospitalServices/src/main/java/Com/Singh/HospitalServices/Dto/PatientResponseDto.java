package Com.Singh.HospitalServices.Dto;

import Com.Singh.HospitalServices.Entity.Type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {

    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
    private InsuranceResponseDto  insurance;
}
