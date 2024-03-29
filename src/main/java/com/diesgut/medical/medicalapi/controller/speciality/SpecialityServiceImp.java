package com.diesgut.medical.medicalapi.controller.speciality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diesgut.medical.medicalapi.dao.ISpecialityDao;
import com.diesgut.medical.model.Speciality;

@Service
@Transactional(readOnly = true)
public class SpecialityServiceImp implements ISpecialityService {

	@Autowired
	ISpecialityDao iSpecialityDao;

	@Override
	@Transactional
	public void save(Speciality speciality) {
		iSpecialityDao.save(speciality);
	}

	@Override
	@Transactional
	public void update(Speciality speciality) {
		iSpecialityDao.update(speciality);
	}

	@Override
	@Transactional
	public void deleteSpeciality(Speciality speciality) {
		iSpecialityDao.delete(speciality.getId());
	}

	@Override
	public List<Speciality> allSpecialities() {
		return iSpecialityDao.all();
	}

	@Override
	public Speciality findSpeciality(Long idSpeciality) {
		return iSpecialityDao.find(idSpeciality);
	}

}
