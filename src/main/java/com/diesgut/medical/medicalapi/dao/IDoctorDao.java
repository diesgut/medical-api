package com.diesgut.medical.medicalapi.dao;

import java.util.List;

import com.diesgut.medical.model.Doctor;
import com.diesgut.medical.model.Speciality;

public interface IDoctorDao extends EasyDAO<Doctor> {
	
	List<Doctor> allBySpeciality(Speciality speciality);
	
}
