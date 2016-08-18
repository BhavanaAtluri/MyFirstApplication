package com.test.example.web;

import java.security.Principal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.example.dto.DeviceDto;
import com.test.example.jpa.Device;
import com.test.example.service.DeviceService;


@RestController
//@RequestMapping("/device")
@EnableResourceServer
public class ControllerExample {
	@Autowired
	private DeviceService deviceService;
	
	ControllerExample(DeviceService deviceService){
		this.deviceService = deviceService;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Device create(@RequestBody Device deviceDto) throws Exception{
		System.out.println(deviceDto.toString());
		
		return deviceService.Save(deviceDto);
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String save(){
		
		
		return "Hello";
	}
	
	
	@RequestMapping(value="/findById/{id}", method=RequestMethod.GET)
	@ResponseBody
	public DeviceDto findById(@PathVariable("id") String id){
		DeviceDto deviceDto = deviceService.findById(id);
		System.out.println(deviceDto.toString());
		return deviceDto;
	}
	
	@RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
	@ResponseBody
	public List<DeviceDto> findByDeviceName(@PathVariable("name") String name){
		return deviceService.findByDeviceName(name);
	}
	
	@RequestMapping(value="/findFromDate/{date}", method=RequestMethod.GET)
	@ResponseBody
	public List<DeviceDto> findByDate(@PathVariable("date") String dateString) throws Exception{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		
		Date date= format.parse(dateString);
		
		return deviceService.findByEventDateGreaterThan(date);
	}
	
	/*@RequestMapping(value="/findByTime/{time}", method=RequestMethod.GET)
	@ResponseBody
	public List<Device> findByTime(@PathVariable("time") Time time){
		return deviceService.findByEventTime(time);
	}*/
	
	
}
