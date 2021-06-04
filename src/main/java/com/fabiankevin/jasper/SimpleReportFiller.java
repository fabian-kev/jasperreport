package com.fabiankevin.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class SimpleReportFiller {

    private String reportFileName;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;


    private Map<String, Object> parameters;

    public SimpleReportFiller() {
        parameters = new HashMap<>();
    }

    public void prepareReport() {
//        compileReport();
        fillReport();
    }

    public void compileReport() {
        try {
//            System.out.println("resource " +  getClass().getResource("/employee.jrxml"));
            System.out.println("file name reportFileName "+reportFileName);
            InputStream reportStream = getClass().getResourceAsStream("/".concat("employee.jrxml"));

            jasperReport = JasperCompileManager.compileReport(
                    reportStream

            );
            jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
            JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
            System.out.println("done?");
        } catch (JRException ex) {
            System.out.println("IS IT ERROR? " +ex.getMessage());
            Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillReport() {
        try {
            System.out.println("parameters " + parameters);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource(1));
            System.out.println("JASPER PRINT done");
            System.out.println("jasper print - > "+jasperPrint);
        } catch (JRException ex) {
            System.out.println("fillReport ERROR JASPER PRINT "+ex.getMessage());
            ex.printStackTrace();
            Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

}