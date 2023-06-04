package com.example.terramodusv1.controller.devisPersonne;

import com.example.terramodusv1.entities.devisPersonne.DevisPersonneAmiable;
import com.example.terramodusv1.repositories.DemandeurPersonneRepository;
import com.example.terramodusv1.repositories.TypeDevisRepository;
import com.example.terramodusv1.repositories.devisPersonne.DevisPersonneAmiableRepository;
import com.example.terramodusv1.service.DevisPersonneAmiableService;
import com.example.terramodusv1.service.DistanceCalcService;
import com.example.terramodusv1.service.EmailService;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devise-personne-amiable")
@CrossOrigin()
public class DevisPersonneAmiableController {

    @Autowired
    private DevisPersonneAmiableService devisPersonneAmiableService;


    
    @PostMapping("/")
    public DevisPersonneAmiable saveDevise(@RequestBody DevisPersonneAmiable devise) throws MessagingException, jakarta.mail.MessagingException, JRException, IOException, ParseException, XmlException {
        return devisPersonneAmiableService.saveDevise(devise);
    }

    
    @GetMapping("/")
    public List<DevisPersonneAmiable> findAll() {
        return devisPersonneAmiableService.findAll();
    }

    
    @GetMapping("/id/{id}")
    public Optional<DevisPersonneAmiable> findById(Long id) {
        return devisPersonneAmiableService.findById(id);
    }

    
    @PutMapping("/")
    public int update(@RequestBody DevisPersonneAmiable devise) {
        return devisPersonneAmiableService.update(devise);
    }
}
