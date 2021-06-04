package com.fabiankevin.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.InputStream;
import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
//
        SimpleReportFiller simpleReportFiller = new SimpleReportFiller();

        SimpleReportExporter simpleReportExporter = new SimpleReportExporter();

//
//        simpleReportFiller.setReportFileName("employeeEmailReport.jrxml");
//        simpleReportFiller.compileReport();
//
        simpleReportFiller.setReportFileName("employee.jrxml");
        simpleReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report Example");
        parameters.put("lastName", "Kevin Pogi");
            parameters.put("testingParameter", "This is a string.");
//        parameters.put("minSalary", 15000.0);
//        parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");


            simpleReportFiller.setParameters(parameters);
            simpleReportFiller.fillReport();

            simpleReportExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

            JasperExportManager.exportReportToPdfFile(simpleReportFiller.getJasperPrint(), "fromXml.pdf");
            simpleReportExporter.exportToPdf("employeeRepor1t.pdf", "baeldung");
            simpleReportExporter.exportToCsv("employeeReport.csv");
            simpleReportExporter.exportToHtml("employeeReport.html");
        } catch (Exception e) {
            e.printStackTrace();
        }




////        simpleReportExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");




    }
    public static List<Employee> employeeList(){
        List<Employee> list = new ArrayList<>();


        Employee kevin= new Employee();
        kevin.setFirstName("Kevin");
        kevin.setLastName("Fabian");
        kevin.setSalary(10000.00);
        kevin.setId(1l);
        return list;
    }
}
