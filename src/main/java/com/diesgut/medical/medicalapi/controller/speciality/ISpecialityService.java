package com.diesgut.medical.medicalapi.controller.speciality;

import java.util.List;

import com.diesgut.medical.model.Speciality;

public interface ISpecialityService {

	void save(Speciality speciality);

	void update(Speciality speciality);

	List<Speciality> allSpecialities();

	Speciality findSpeciality(Long idSpeciality);

	void deleteSpeciality(Speciality speciality);

}
