package com.SpringApp.service;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.Admin;
import com.SpringApp.repository.AdminRepository;

//It is used to mark the class as a service provider. 
//So overall @Service annotation is used with classes that provide some business functionalities
//this class is a implementation of methods
	@Service
	public class AdminServiceImpl  implements AdminService {
		
	private AdminRepository admRepo;
		
		@Autowired
		public AdminServiceImpl(AdminRepository admRepo) {
			super();
			this.admRepo = admRepo;
		}

		@Override
		public Admin addCar(Admin adm) throws CarAlreadyExistsException { //for adding data
			// TODO Auto-generated method stub
			if(admRepo.existsById(adm.getUserId())) {
				throw new CarAlreadyExistsException();
			}
			Admin savedAdm = admRepo.save(adm);
			return savedAdm;
		}

		@Override
		public List<Admin> getAllCars() {      //for getting the data
			// TODO Auto-generated method stub
			return (List<Admin>) admRepo.findAll();
		}

		@Override
		public void deleteCarByid(int id) {   //for delete the data
			admRepo.deleteById(id);
		}

		@Override
		public Admin updateCar(Admin adm) {    //for updating a data
			// TODO Auto-generated method stub
			Admin record;
			Optional<Admin> opt=admRepo.findById(adm.getUserId());
			if(opt.isPresent()) {
				record=opt.get();
				record.setUserId(adm.getUserId());
				record.setUserName(adm.getUserName());
				admRepo.save(record);
			}else {
				return new Admin();
			}
			return record;
		}
	}

