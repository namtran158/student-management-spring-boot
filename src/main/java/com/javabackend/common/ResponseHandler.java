package com.javabackend.common;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("content", obj);
		map.put("hasErrors", false);
		map.put("errors", "");
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(Object obj, HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(obj instanceof BindingResult) {
			map.put("errors", ErrorUtil.solveError((BindingResult)obj));
		} else {
			map.put("errors", obj);
		}
		
		map.put("content", "");
		map.put("hasErrors", true);
		map.put("pageIndex", 0);
		map.put("pageSize", 0);
		map.put("total", 0);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(HttpStatus ok) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("content", "OK");
		map.put("hasErrors", false);
		map.put("errors", "");
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", ok.value());

		return new ResponseEntity<Object>(map, ok);
	}
}
