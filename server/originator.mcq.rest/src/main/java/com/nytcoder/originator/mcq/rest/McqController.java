package com.nytcoder.originator.mcq.rest;

import java.util.ArrayList;
import java.util.List;

import org.originator.common.RestUrlPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nytcoder.originator.mcq.model.QueChoiceDto;
import com.nytcoder.originator.mcq.model.Subject;
import com.nytcoder.originator.mcq.service.McqService;

@RestController
@RequestMapping(value = RestUrlPath.baseRestPath)
public class McqController {
	
	@Autowired
	McqService mcqService;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestUrlPath.GetSubject, method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> getSubject(){
		ResponseEntity<List<Subject>> responseEntity = null;
		List<Subject> subjectList = new ArrayList<Subject>();
		try {
			subjectList = mcqService.getAllSubject();
			responseEntity = new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(){
		return ("<h1>Welcome</h1>");
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = RestUrlPath.GetQuestion, method = RequestMethod.GET)
	public ResponseEntity<List<QueChoiceDto>> getQuestion(@RequestParam(value = "subjectId") Long subjectId){
		ResponseEntity<List<QueChoiceDto>> responseEntity = null;
		List<QueChoiceDto> queChoiceDtos = new ArrayList<QueChoiceDto>();
		try {
			queChoiceDtos = mcqService.getQuestion(subjectId);
			responseEntity = new ResponseEntity<List<QueChoiceDto>>(queChoiceDtos, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
