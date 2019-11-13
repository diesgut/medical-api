package com.diesgut.medical.medicalapi.dao.imp;

import org.springframework.stereotype.Repository;

import com.diesgut.medical.medicalapi.dao.EasyDAO;
import com.diesgut.medical.medicalapi.dao.IPatientDao;
import com.diesgut.medical.model.Patient;

@Repository
public class PatientDaoImp extends AbstractEasyDao<Patient> implements IPatientDao, EasyDAO<Patient> {

	public PatientDaoImp() {
		super();
		setClazz(Patient.class);
	}
}
