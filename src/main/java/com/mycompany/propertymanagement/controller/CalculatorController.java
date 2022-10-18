package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/calculator")//class level mapping of url to a controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    //http://localhost:8080/api/v1/calculator/add?num1=6.7&num2=1.3
    @GetMapping(value = "/add")// method level mapping of a url to a controller function
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
       return num1+num2;
    }

    //http://localhost:8080/api/v1/calculator/sub/4.8/9.7
    @GetMapping(value = "/sub/{num1}/{num2}")//Map the values of url using Path variable method
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1-num2;
        }else{
            result = num2-num1;
        }
        return result;
    }

    //This is the normal multiplication with class mapping
   /* @PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        //return result;
        return responseEntity; */

       //This is for response entity
        @PostMapping("/mul")
        public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
            Double result = null;
            result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
            ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
            //return result;
            return responseEntity;
    }
}
