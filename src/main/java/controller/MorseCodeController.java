package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.MorseCodeBean;
import bean.ResponseBean;
import errorMessages.ErrorMessages;
import helper.MorseCodeHelper;
import morseCodeException.MorseCodeException;

@Controller
@EnableAutoConfiguration
public class MorseCodeController {

	@RequestMapping(value = "/translate/2text", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> translate2text(@RequestBody MorseCodeBean morseCode) {

		String result, code = "";
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			result = MorseCodeHelper.translate2Text(morseCode.getText());
			code = httpStatus.toString();
		} catch (MorseCodeException e) {
			result = e.getMessage();
			httpStatus = HttpStatus.BAD_REQUEST;
			code = httpStatus.toString();
		} catch (Exception e) {
			result = ErrorMessages.UNHANDLED_ERROR;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			code = httpStatus.toString();
		} 

		ResponseBean response = new ResponseBean();
		response.setCode(code);
		response.setResponse(result);
		
		return new ResponseEntity<ResponseBean>(response, httpStatus);
	}
	
	@RequestMapping(value = "/translate/2morse", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> translate2morse(@RequestBody MorseCodeBean characters) {

		String result, code = "";
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			result = MorseCodeHelper.translate2Morse(characters.getText());
			code = httpStatus.toString();
		} catch (MorseCodeException e) {
			result = e.getMessage();
			httpStatus = HttpStatus.BAD_REQUEST;
			code = httpStatus.toString();
		} catch (Exception e) {
			result = ErrorMessages.UNHANDLED_ERROR;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			code = httpStatus.toString();
		} 
		
		ResponseBean response = new ResponseBean();
		response.setCode(code);
		response.setResponse(result);
		
		return new ResponseEntity<ResponseBean>(response, httpStatus);
	}	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MorseCodeController.class, args);
	}
}