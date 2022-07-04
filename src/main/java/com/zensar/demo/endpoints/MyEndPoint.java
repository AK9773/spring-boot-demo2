package com.zensar.demo.endpoints;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myEndPoint")
public class MyEndPoint {

	@ReadOperation
	public String sayHello() {
		return "<h2> Hello</h2>";
	}

}
