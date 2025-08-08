package Com.Singh.HospitalServices.Dto;

import Com.Singh.HospitalServices.Entity.Type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDto {

    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;
    private Long userId;                        // If user already exists
    private InsuranceRequestDto insurance;      // Optional if assigning insurance during creation
}
