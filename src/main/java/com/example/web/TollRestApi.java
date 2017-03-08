package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TollUsage;
import com.example.service.TollServiceIntf;

@RestController
public class TollRestApi {

	@Autowired
	TollServiceIntf tollServiceIntf; 
	
	@RequestMapping(value="/client")
	public List<TollUsage> findAll(){
		return tollServiceIntf.findAll();
	}
	
	@RequestMapping(value="/client/{id}")
	public TollUsage getById(String id){
		return tollServiceIntf.getById(id);
	}
}
