package com.example.demo.services.impl;

import com.example.demo.dtos.DrugDetailsDTO;
import com.example.demo.entitys.DrugDetails;
import com.example.demo.repositorys.DrugDetailsRepo;
import com.example.demo.services.DrugDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DrugDetailsServiceIMPL implements DrugDetailsService {

    @Autowired
    private DrugDetailsRepo drugDetailsRepo;

    @Override
    public String saveDrugDetails(DrugDetailsDTO dto) {
        DrugDetails drugDetails = new DrugDetails(
                dto.getId(), dto.getName(), dto.getGeneric(), dto.getDose(), dto.getQuantity()
        );
        return drugDetailsRepo.save(drugDetails).getId() + " - Saved!";
    }

    @Override
    public DrugDetailsDTO getDrugDetails(String id) {
        Optional tempData = drugDetailsRepo.findById(id);
        if (tempData.isPresent()) {
            DrugDetails d = (DrugDetails) tempData.get();
            return new DrugDetailsDTO(d.getId(), d.getName(), d.getGeneric(), d.getDose(), d.getQuantity());
        }
        return null;
    }

    @Override
    public ArrayList<DrugDetailsDTO> loadAllDrugsDetails() {
        ArrayList<DrugDetailsDTO> dtoList = new ArrayList<>();
        drugDetailsRepo.findAll().forEach(d -> {
            dtoList.add(
                    new DrugDetailsDTO(d.getId(), d.getName(), d.getGeneric(), d.getDose(), d.getQuantity())
            );
        });
        return dtoList;
    }

    @Override
    public String deleteDrugDetails(String id) {
        drugDetailsRepo.deleteById(id);
        return id + " - Deleted!";
    }

    @Override
    public String updateDrugDetails(DrugDetailsDTO dto) {
        Optional<DrugDetails> byId = drugDetailsRepo.findById(dto.getId());
        if (byId.isPresent()) {
            DrugDetails drugDetails = byId.get();
            drugDetails.setName(dto.getName());
            drugDetails.setGeneric(dto.getGeneric());
            drugDetails.setDose(dto.getDose());
            drugDetails.setQuantity(dto.getQuantity());
            return drugDetailsRepo.save(drugDetails).getId() + " - Updated!";
        } else {
            return "Empty Result";
        }
    }
}
