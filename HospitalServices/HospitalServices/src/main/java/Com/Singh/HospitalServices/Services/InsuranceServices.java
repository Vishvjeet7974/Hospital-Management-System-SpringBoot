package Com.Singh.HospitalServices.Services;

import Com.Singh.HospitalServices.Entity.Insurance;
import Com.Singh.HospitalServices.Entity.Patient;

public interface InsuranceServices {


    Patient assignInsuranceToPatient(Insurance insurance, Long patientId);

    Patient disaccociateInsuranceFromPatient(Long patientId);
}
