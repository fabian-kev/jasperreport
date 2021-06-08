package com.fabiankevin.jasper;

import net.sf.jasperreports.engine.JasperExportManager;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        try {
////
        SimpleReportFiller simpleReportFiller = new SimpleReportFiller();
        SimpleReportExporter simpleReportExporter = new SimpleReportExporter();

        Employee employee = new Employee();
        employee.setId(1l);
        employee.setSalary(2000.25);
        employee.setLastName("FABIAN");
        employee.setFirstName("KEVIN");


            simpleReportFiller.setReportFileName("1-header.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("2-account-details.jrxml");
            simpleReportFiller.compileReport();


            simpleReportFiller.setReportFileName("3-person-details.jrxml");
            simpleReportFiller.compileReport();


            simpleReportFiller.setReportFileName("4-address.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("5-other-details.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("6-fatca-info.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("7-certification.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("8-accomplished.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("9-customer-wet-signature.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("10-ATM.jrxml");
            simpleReportFiller.compileReport();


            simpleReportFiller.setReportFileName("11-other-channel.jrxml");
            simpleReportFiller.compileReport();
            simpleReportFiller.setReportFileName("12-bank-use-only.jrxml");
            simpleReportFiller.compileReport();

            simpleReportFiller.setReportFileName("DOBForm.jrxml");
        simpleReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report Example");
        parameters.put("lastName", "Kevin Pogi");
            parameters.put("testingParameter", "This is a string.");
            parameters.put("employee", employee);


            simpleReportFiller.setParameters(parameters);
            simpleReportFiller.fillReport();

            simpleReportExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

//            HashMap<String, Object> params = new HashMap<String, Object>();
//            params.put("logo", ClassLoader.getSystemResource("logo.jpg").getPath());

            JasperExportManager.exportReportToPdfFile(simpleReportFiller.getJasperPrint(), "sample.pdf");
//            simpleReportExporter.exportToPdf("employeeRepor1t.pdf", "baeldung");
//            simpleReportExporter.exportToCsv("employeeReport.csv");
//            simpleReportExporter.exportToHtml("employeeReport.html");
        } catch (Exception e) {
            e.printStackTrace();
        }



////        simpleReportExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");




    }
}
