package com.example.repository;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.TollUsage;

@FeignClient("tollusagems")
public interface TollUsageFeignMSRepo {

	@RequestMapping("/tolls")
	public List<TollUsage> findAll();
	
	@RequestMapping("/tolls/{id}")
	public TollUsage findById(@PathVariable("id")String id);
	
}
