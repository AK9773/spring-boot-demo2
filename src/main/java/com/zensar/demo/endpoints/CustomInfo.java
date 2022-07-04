package com.zensar.demo.endpoints;

import org.springframework.boot.actuate.info.Info.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;


@Component
public class CustomInfo implements InfoContributor{
	private Map<String, String> infoEndPoint = new HashMap<>();
	
	
	@Override
	public void contribute(Builder builder) {
		infoEndPoint.put("CreatedBy", "Aman Kumar");
		infoEndPoint.put("Modified", "22 July 2022");
		builder.withDetail("Student", infoEndPoint);
		
	}

}
