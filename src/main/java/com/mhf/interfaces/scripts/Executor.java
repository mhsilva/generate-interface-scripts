package com.mhf.interfaces.scripts;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Executor {

    private static final String filePath = "C:\\Users\\U6047034.TEN\\Desktop\\FTA\\Pre_prod_header.xlsx";
    private static final String outputPath = "C:\\Users\\U6047034.TEN\\Desktop\\interfaces_output.txt";
    private static List<String> validCompanies = Arrays.asList("0100"); 
    
    public static void main(String[] args) throws Exception {
        ExcelReading excelReading = new ExcelReading(filePath);
        List<InterfaceHeaderPojo> loadHeader = excelReading.loadHeader();
        Map<String, List<InterfaceDetailPojo>> loadDetails = excelReading.loadDetails();
        System.out.println(loadHeader.size());
        System.out.println(loadDetails.size());
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN\n");
        for (InterfaceHeaderPojo interfaceHeaderPojo : loadHeader) {
            if (!validCompanies.contains(interfaceHeaderPojo.getCompanyCode())) {
                continue;
            }
            sb.append("BEGIN\n");
            sb.append(MessageFormat.format("DELETE FROM IN_INTRFC_LIST WHERE TENANCY_ID = ''{0}'' AND INTRFC_CODE = ''{1}'' AND COMPANY_CODE = ''{2}'';\n", interfaceHeaderPojo.getTenancyId(), interfaceHeaderPojo.getIntrfcCode(), interfaceHeaderPojo.getCompanyCode()));
            sb.append("END;\n");
            boolean haveDetail = false;
            String intrfcListId = interfaceHeaderPojo.getIntrfcListId();
            sb.append("BEGIN\n");
            sb.append(MessageFormat.format(SqlConstants.headerCall, interfaceHeaderPojo.getTenancyId(), interfaceHeaderPojo.getCompanyCode(), interfaceHeaderPojo.getIntrfcCode(),
                interfaceHeaderPojo.getIntrfcNm(), interfaceHeaderPojo.getIntrfcDc(), interfaceHeaderPojo.getTmprTable(), interfaceHeaderPojo.getLastTable(),
                interfaceHeaderPojo.getLastTablePkColumn(), interfaceHeaderPojo.getTmprPrecUserProgrm(), interfaceHeaderPojo.getTmprListDetailUserProgrm(), interfaceHeaderPojo.getLastUserPrecProgrm(),
                interfaceHeaderPojo.getLastCmmnProgrm(), interfaceHeaderPojo.getLastCmmnAddProgrm(), interfaceHeaderPojo.getLastUserProgrm(), interfaceHeaderPojo.getWsrvProgrm(),
                interfaceHeaderPojo.getEleMainLevel(), interfaceHeaderPojo.getFrgnColumn(), interfaceHeaderPojo.getFrgnColumnProgrm(), interfaceHeaderPojo.getPkCeckYn(),
                interfaceHeaderPojo.getUseYn(), interfaceHeaderPojo.getUpdateBy(), interfaceHeaderPojo.getIntrfcSeCode(), interfaceHeaderPojo.getSmpleFileNm(), interfaceHeaderPojo.getSmpleFile(),
                interfaceHeaderPojo.getExcelDataStartRowNo(), interfaceHeaderPojo.getSmpleFixingYn(), interfaceHeaderPojo.getIntrfcEndDate()));
            sb.append("BEGIN\n");
            for (InterfaceDetailPojo interfaceDetailPojo : loadDetails.get(intrfcListId)) {
                haveDetail = true;
                sb.append(MessageFormat.format(SqlConstants.detailCall, interfaceDetailPojo.getTenancyId(), interfaceHeaderPojo.getCompanyCode(), interfaceHeaderPojo.getIntrfcCode(),
                    interfaceHeaderPojo.getIntrfcEndDate(), interfaceDetailPojo.getIntrfcTyCode(), interfaceDetailPojo.getColumnNm(), interfaceDetailPojo.getColumnDc(),
                    interfaceDetailPojo.getEleCourse(), interfaceDetailPojo.getEleNm(), interfaceDetailPojo.getUserPrecProgrm(), interfaceDetailPojo.getCmmnProgrm(),
                    interfaceDetailPojo.getUserProgrm(), interfaceDetailPojo.getTmprColumn(), interfaceDetailPojo.getLastColumn(), interfaceDetailPojo.getLastColumnTrnsferYn(),
                    interfaceDetailPojo.getHideYn(), interfaceDetailPojo.getColumnTyCode(), interfaceDetailPojo.getColumnLt(), interfaceDetailPojo.getColumnDcmlpointLt(),
                    interfaceDetailPojo.getColumnFrmatFom(), interfaceDetailPojo.getColumnDfltVal(), interfaceDetailPojo.getColumnVrifyProgrmNm(), interfaceDetailPojo.getColumnRequiYn(),
                    interfaceDetailPojo.getColumnPkYn(), interfaceDetailPojo.getSmpleData(), interfaceDetailPojo.getUseYn(), interfaceDetailPojo.getUpdateBy(),
                    interfaceDetailPojo.getColumnTrnsferGroupYn(), interfaceDetailPojo.getRefrnCode(), interfaceDetailPojo.getSmpleColumnFixingYn()));
            }
            if (!haveDetail) {
                System.out.println(intrfcListId + " doesnt have item");
            }
            sb.append("END;\n");
            sb.append("END;\n");
        }
        sb.append("END;\n");
        excelReading.closeThatShit();
        Path file = Paths.get(outputPath);
        Files.write(file, sb.toString().replaceAll("''", "NULL").getBytes());
    }
}
