package Com.Singh.HospitalServices.Dto;


import lombok.Data;

@Data
public class AssignInsuranceRequestDto {

     private Long patientId;
     private InsuranceRequestDto insurance;
}
