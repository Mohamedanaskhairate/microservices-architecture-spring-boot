package org.sid.copropriete_service.controllers;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.copropriete_service.enums.Statut_Type;
import org.springframework.web.bind.annotation.*;
import org.sid.copropriete_service.entities.CompteBancaire;
import org.sid.copropriete_service.entities.Copropriete;
import org.sid.copropriete_service.services.Coproprieteservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin("http://localhost:8081")
public class CoproprieteController {
    @Autowired
    private Coproprieteservice coproprieteservice;
    @GetMapping("/coproprietes/rechercherParNom")
    public List<Copropriete> rechercherParNom(@RequestParam("nom") String nom) {
        return coproprieteservice.rechercherParNom(nom);
    }
    @GetMapping("/coproprietes/rechercherParVille")
    public List<Copropriete> rechercherParVille(@RequestParam("ville") String ville) {
        return coproprieteservice.rechercherParVille(ville);
    }
    @GetMapping("/coproprietes/rechercherParStatut")
    public List<Copropriete> rechercherParStatut(@RequestParam("statut") Statut_Type statut) {
        return coproprieteservice.rechercherParStatut(statut);
    }
    @GetMapping("/coproprietes/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=Copropriete.xls";
        response.setHeader(headerKey, headerValue);
        coproprieteservice.generateExcel(response);
        response.flushBuffer();
    }
}