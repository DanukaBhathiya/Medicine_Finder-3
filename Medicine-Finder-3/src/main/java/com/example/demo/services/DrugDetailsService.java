package com.example.demo.services;

import com.example.demo.dtos.DrugDetailsDTO;

import java.util.ArrayList;

public interface DrugDetailsService {
    public String saveDrugDetails(DrugDetailsDTO dto);
    public DrugDetailsDTO getDrugDetails(String id);
    public ArrayList<DrugDetailsDTO> loadAllDrugsDetails();
    public String deleteDrugDetails(String Id);
    public String updateDrugDetails(DrugDetailsDTO dto);
}
