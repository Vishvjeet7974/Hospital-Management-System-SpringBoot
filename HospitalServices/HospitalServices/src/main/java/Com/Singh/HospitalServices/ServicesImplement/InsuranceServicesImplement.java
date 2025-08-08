package Com.Singh.HospitalServices.ServicesImplement;

import Com.Singh.HospitalServices.Entity.Insurance;
import Com.Singh.HospitalServices.Entity.Patient;
import Com.Singh.HospitalServices.Repository.InsuranceRepository;
import Com.Singh.HospitalServices.Repository.PatientRepository;
import Com.Singh.HospitalServices.Services.InsuranceServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InsuranceServicesImplement implements InsuranceServices {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelMapper modelMapper;



    @Override
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        insuranceRepository.save(insurance);

        patient.setInsurance(insurance);
        insurance.setPatient(patient);   // Here dirty checking automatically update and save

        return patient;

    }

    @Override
    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with Id"));

        patient.setInsurance(null);

        return patient;
    }
}
