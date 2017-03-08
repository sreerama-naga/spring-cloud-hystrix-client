package com.example.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.TollUsage;

public interface TollServiceIntf {

	public List<TollUsage> findAll();
	
	public TollUsage getById(String id);
}
