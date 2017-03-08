package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TollUsage;
import com.example.repository.TollUsageFeignMSRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TollService implements TollServiceIntf{

	@Autowired
	TollUsageFeignMSRepo feignRepo; 
	
	/*@RequestMapping(value="/client")*/
	@Override
	@HystrixCommand(fallbackMethod="listOfTollUsageFallBack")
	public List<TollUsage> findAll(){
		return feignRepo.findAll();
	}
	
	public List<TollUsage> listOfTollUsageFallBack(){
		
		List<TollUsage> tollUsages = new ArrayList<TollUsage>();
		
		tollUsages.add(new TollUsage("id-dummy","station-dummy","licenseplate-dummy","timestamp-dummy"));
		
		return tollUsages;
	}
	
/*	@SuppressWarnings("unchecked")
	@RequestMapping(value="/client/{id}")*/
	@Override
	public TollUsage getById(String id){
		return feignRepo.findById(id);
	}
}
