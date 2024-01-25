package org.sid.copropriete_service.services;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sid.copropriete_service.entities.Copropriete;
import org.sid.copropriete_service.enums.Statut_Type;
import org.sid.copropriete_service.repository.CoproprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class Coproprieteservice {
    @Autowired
    private CoproprieteRepository coproprieteRepository;

    public List<Copropriete> rechercherParNom(String nom) {
        return coproprieteRepository.findByNom(nom);
    }
    public List<Copropriete> rechercherParVille(String ville) {
        return coproprieteRepository.findByVille(ville);
    }
    public List<Copropriete> rechercherParStatut(Statut_Type statut) {
        return coproprieteRepository.findByStatut(statut);
    }

    public void generateExcel(HttpServletResponse response) throws Exception {
        List<Copropriete> coproprieteList = coproprieteRepository.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("copropriete info ");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("code");
        row.createCell(1).setCellValue("nom");
        row.createCell(2).setCellValue("ville");

        int dataRowIndex = 1;
        for (Copropriete copropriete : coproprieteList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(copropriete.getCode());
            dataRow.createCell(1).setCellValue(copropriete.getVille());
            dataRow.createCell(2).setCellValue(copropriete.getNom());

            dataRowIndex++;
        }
        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
    public Copropriete getCoproprieteById(Long id) {
        return coproprieteRepository.findById(id).orElse(null);
    }

    //public Copropriete getCoproprieteById(Long id) {
    // return coproprieteRepository.findById(id).orElse(null);
    //}

}