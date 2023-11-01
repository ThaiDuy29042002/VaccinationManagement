package com.example.vaccination.service.impl;

import com.example.vaccination.Validator.VaccineValidator;
import com.example.vaccination.exception.NotFoundException;
import com.example.vaccination.model.entity.Vaccine;
import com.example.vaccination.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VaccineServiceImpl {

    @Autowired
    private VaccineRepository repository;

    public List<Vaccine> getAllVaccine() {
        return this.repository.findAll();
    }

    public Vaccine addNew(Vaccine p) {
        return repository.save(p);
    }

    public void saveByExcel(List<Vaccine> file) {
        this.repository.saveAll(file);
    }

    public Vaccine findByVaccineName(String name) {
        try {
            return repository.findByVaccineName(name).orElse(null);
        } catch (NotFoundException ex) {
            throw ex;
        }
    }

    public Vaccine findById(String id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (NotFoundException ex) {
            throw ex;
        }
    }
}
