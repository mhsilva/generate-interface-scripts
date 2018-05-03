package com.mhf.interfaces.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading<V> {

    private Workbook wb;

    public ExcelReading(String fileName) throws Exception {
        wb = new XSSFWorkbook(new FileInputStream(new File(fileName)));
    }
    
    public void closeThatShit() throws Exception {
        wb.close();
    }

    private Iterator<Row> getRowIteratorForSheetAt(int index) {
        Iterator<Row> rowIterator = wb.getSheetAt(index).rowIterator();
        rowIterator.next();
        return rowIterator;
    }

    private String getCellValue(Row row,
        int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            return "";
        }
        cell.setCellType(CellType.STRING);
        String stringCellValue = cell.getStringCellValue();
        return stringCellValue.replaceAll("\\n", "").replaceAll("\\r", "");
    }

    public List<InterfaceHeaderPojo> loadHeader() {
        List<InterfaceHeaderPojo> result = new ArrayList<InterfaceHeaderPojo>();
        Iterator<Row> rowIterator = getRowIteratorForSheetAt(0);
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            InterfaceHeaderPojo header = new InterfaceHeaderPojo();
            int i = 0;
            header.setTenancyId(getCellValue(row, i++));
            header.setIntrfcListId(getCellValue(row, i++));
            header.setCompanyCode(getCellValue(row, i++));
            header.setIntrfcCode(getCellValue(row, i++));
            header.setIntrfcNm(getCellValue(row, i++));
            header.setIntrfcDc(getCellValue(row, i++));
            header.setTmprTable(getCellValue(row, i++));
            header.setLastTable(getCellValue(row, i++));
            header.setLastTablePkColumn(getCellValue(row, i++));
            header.setTmprPrecUserProgrm(getCellValue(row, i++));
            header.setTmprListDetailUserProgrm(getCellValue(row, i++));
            header.setLastUserPrecProgrm(getCellValue(row, i++));
            header.setLastCmmnProgrm(getCellValue(row, i++));
            header.setLastCmmnAddProgrm(getCellValue(row, i++));
            header.setLastUserProgrm(getCellValue(row, i++));
            header.setWsrvProgrm(getCellValue(row, i++));
            header.setEleMainLevel(getCellValue(row, i++));
            header.setFrgnColumn(getCellValue(row, i++));
            header.setFrgnColumnProgrm(getCellValue(row, i++));
            header.setPkCeckYn(getCellValue(row, i++));
            header.setUseYn(getCellValue(row, i++));
            header.setCreateDate(getCellValue(row, i++));
            header.setCreateBy(getCellValue(row, i++));
            header.setUpdateDate(getCellValue(row, i++));
            header.setUpdateBy(getCellValue(row, i++));
            header.setSmpleFileNm(getCellValue(row, i++));
            header.setSmpleFile(getCellValue(row, i++));
            header.setExcelDataStartRowNo(getCellValue(row, i++));
            header.setIntrfcSeCode(getCellValue(row, i++));
            header.setSmpleFixingYn(getCellValue(row, i++));
            header.setIntrfcEndDate(getCellValue(row, i++));
            result.add(header);
        }
        return result;
    }

    public Map<String, List<InterfaceDetailPojo>> loadDetails() {
        Map<String, List<InterfaceDetailPojo>> result = new HashMap<String, List<InterfaceDetailPojo>>();
        Iterator<Row> rowIterator = getRowIteratorForSheetAt(1);
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            InterfaceDetailPojo r = new InterfaceDetailPojo();
            int i = 0;
            r.setTenancyId(getCellValue(row, i++));
            r.setIntrfcListDetailId(getCellValue(row, i++));
            r.setIntrfcListId(getCellValue(row, i++));
            r.setIntrfcTyCode(getCellValue(row, i++));
            r.setColumnNm(getCellValue(row, i++));
            r.setColumnDc(getCellValue(row, i++));
            r.setEleCourse(getCellValue(row, i++));
            r.setEleNm(getCellValue(row, i++));
            r.setUserPrecProgrm(getCellValue(row, i++));
            r.setCmmnProgrm(getCellValue(row, i++));
            r.setUserProgrm(getCellValue(row, i++));
            r.setTmprColumn(getCellValue(row, i++));
            r.setLastColumn(getCellValue(row, i++));
            r.setLastColumnTrnsferYn(getCellValue(row, i++));
            r.setColumnTyCode(getCellValue(row, i++));
            r.setColumnLt(getCellValue(row, i++));
            r.setColumnDcmlpointLt(getCellValue(row, i++));
            r.setColumnFrmatFom(getCellValue(row, i++));
            r.setColumnDfltVal(getCellValue(row, i++));
            r.setColumnVrifyProgrmNm(getCellValue(row, i++));
            r.setColumnRequiYn(getCellValue(row, i++));
            r.setColumnPkYn(getCellValue(row, i++));
            r.setSmpleData(getCellValue(row, i++));
            r.setUseYn(getCellValue(row, i++));
            r.setCreateDate(getCellValue(row, i++));
            r.setCreateBy(getCellValue(row, i++));
            r.setUpdateDate(getCellValue(row, i++));
            r.setUpdateBy(getCellValue(row, i++));
            r.setColumnTrnsferGroupYn(getCellValue(row, i++));
            r.setHideYn(getCellValue(row, i++));
            r.setRefrnCode(getCellValue(row, i++));
            r.setSmpleColumnFixingYn(getCellValue(row, i++));
            if (!result.containsKey(r.getIntrfcListId())) {
                result.put(r.getIntrfcListId(), new ArrayList<InterfaceDetailPojo>());
            }
            result.get(r.getIntrfcListId()).add(r);
        }
        return result;
    }
}
