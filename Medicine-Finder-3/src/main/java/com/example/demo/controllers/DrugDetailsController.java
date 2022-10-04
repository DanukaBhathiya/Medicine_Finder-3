package com.example.demo.controllers;

import com.example.demo.dtos.DrugDetailsDTO;
import com.example.demo.services.DrugDetailsService;
import com.example.demo.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/DrugDetails")
@CrossOrigin
public class DrugDetailsController {

    @Autowired
    private DrugDetailsService drugDetailsService;

    @PostMapping(path = "/admin/member")
    public ResponseEntity<StandardResponseEntity> saveDrugDetails(
            @RequestBody DrugDetailsDTO dto
    ) {
        return new ResponseEntity<StandardResponseEntity>(
                new StandardResponseEntity(200,"Success!",drugDetailsService.saveDrugDetails(dto))
                , HttpStatus.OK);
    }

    @DeleteMapping(path = "/admin/member")
    public ResponseEntity<StandardResponseEntity> deleteDrugDetails(@RequestParam(required = true) String id) {
        return new ResponseEntity<StandardResponseEntity>(
                new StandardResponseEntity(200, "Success!", drugDetailsService.deleteDrugDetails(id))
                , HttpStatus.OK);
    }

    @PutMapping(path = "/admin/member")
    public ResponseEntity<StandardResponseEntity> updateDrugDetails(@RequestBody DrugDetailsDTO dto) {
        return new ResponseEntity<StandardResponseEntity>(
                new
                        StandardResponseEntity(200, "Success!", drugDetailsService.updateDrugDetails(dto))
                , HttpStatus.OK);
    }

    @GetMapping(path = "/admin/member",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            }
    )
    public ResponseEntity<StandardResponseEntity> getDrugDetails(@RequestParam(required = true) String id) {
        DrugDetailsDTO dto = drugDetailsService.getDrugDetails(id);
        if (dto != null) {
            return new ResponseEntity<StandardResponseEntity>(
                    new StandardResponseEntity(200,"Success!",dto)
                    , HttpStatus.OK);
        } else {
            return new ResponseEntity<StandardResponseEntity>(
                    new StandardResponseEntity(404,"Empty Result!",null)
                    , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/admin/member/list")
    public ResponseEntity<StandardResponseEntity> getAllDrugsDetails() {
        return new ResponseEntity<StandardResponseEntity>(
                new StandardResponseEntity(200, "Success!", drugDetailsService.loadAllDrugsDetails())
                , HttpStatus.OK);
    }
}
