package com.example.RegistrationLogin.EmployeeController;

import com.example.RegistrationLogin.Dto.dataJsonDTO;
//import com.example.RegistrationLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("testbfhl.herokuapp.com")
public class EmployeeController {


    @PostMapping(path = "/bfhl")
    public dataJsonDTO saveEmployee(@RequestBody Map<String, Object> requestBody)
    {
        ArrayList<String> data = (ArrayList<String>) requestBody.get("data");
        dataJsonDTO currentData = new dataJsonDTO();
        currentData.setData(data);
        System.out.println(currentData.getData());
        currentData.extractAlphabets();
        System.out.println(currentData.getNumbers());
        currentData.extractNumbers();
        currentData.findHighestLowercaseLetter();
        return currentData;

    }


}
