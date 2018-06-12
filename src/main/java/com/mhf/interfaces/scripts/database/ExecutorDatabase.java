package com.mhf.interfaces.scripts.database;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mhf.interfaces.scripts.SqlConstants;

public class ExecutorDatabase {

    private static final String outputPath = "C:\\teste\\interfaces_output.txt";

    private static List<String> validCompanies = Arrays.asList("1002");

    private static final String DEFAULT_TENANCY_ID = "OGT_FTA_MX_AB";

    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = null;

        try {

            conn = ConnectionDatabase.getConn();

            List<Object> values = new ArrayList<Object>();
            String where = "";

            where += MapperResultSetToSelectedItem.getAndOrWhere(where) + "TENANCY_ID = ?";
            values.add(ExecutorDatabase.DEFAULT_TENANCY_ID);

            List<InIntrfcList> loadHeader = (ArrayList<InIntrfcList>) MapperResultSetToSelectedItem.map(conn, InIntrfcList.class, where, values);
            Map<BigDecimal, List<InIntrfcListDetail>> loadDetails = loadDetailsDatabase(conn);

            System.out.println(loadHeader.size());
            System.out.println(loadDetails.size());
            StringBuilder sb = new StringBuilder();
            sb.append("BEGIN\n");

            for (InIntrfcList inIntrfcList : loadHeader) {
                if (!validCompanies.contains(inIntrfcList.getCompanyCode())) {
                    continue;
                }
                sb.append("BEGIN\n");
                sb.append(MessageFormat.format("DELETE FROM IN_INTRFC_LIST WHERE TENANCY_ID = ''{0}'' AND INTRFC_CODE = ''{1}'' AND COMPANY_CODE = ''{2}'';\n", inIntrfcList.getTenancyId(),
                    inIntrfcList.getIntrfcCode(), inIntrfcList.getCompanyCode()));
                sb.append("END;\n");
                boolean haveDetail = false;
                BigDecimal intrfcListId = inIntrfcList.getIntrfcListId();
                sb.append("BEGIN\n");
                sb.append(MessageFormat.format(SqlConstants.headerCall, inIntrfcList.getTenancyId(), inIntrfcList.getCompanyCode(), inIntrfcList.getIntrfcCode(), inIntrfcList.getIntrfcNm(),
                    inIntrfcList.getIntrfcDc(), inIntrfcList.getTmprTable(), inIntrfcList.getLastTable(), inIntrfcList.getLastTablePkColumn(), inIntrfcList.getTmprPrecUserProgrm(),
                    inIntrfcList.getTmprListDetailUserProgrm(), inIntrfcList.getLastUserPrecProgrm(), inIntrfcList.getLastCmmnProgrm(), inIntrfcList.getLastCmmnAddProgrm(),
                    inIntrfcList.getLastUserProgrm(), inIntrfcList.getWsrvProgrm(), inIntrfcList.getEleMainLevel(), inIntrfcList.getFrgnColumn(), inIntrfcList.getFrgnColumnProgrm(),
                    inIntrfcList.getPkCeckYn(), inIntrfcList.getUseYn(), inIntrfcList.getUpdateBy(), inIntrfcList.getIntrfcSeCode(), inIntrfcList.getSmpleFileNm(), inIntrfcList.getSmpleFile(),
                    inIntrfcList.getExcelDataStartRowNo(), inIntrfcList.getSmpleFixingYn(), inIntrfcList.getIntrfcEndDate()));
                sb.append("BEGIN\n");
                for (InIntrfcListDetail InIntrfcListDetail : loadDetails.get(intrfcListId)) {
                    haveDetail = true;
                    sb.append(MessageFormat.format(SqlConstants.detailCall, InIntrfcListDetail.getTenancyId(), inIntrfcList.getCompanyCode(), inIntrfcList.getIntrfcCode(),
                        inIntrfcList.getIntrfcEndDate(), InIntrfcListDetail.getIntrfcTyCode(), InIntrfcListDetail.getColumnNm(), InIntrfcListDetail.getColumnDc(), InIntrfcListDetail.getEleCourse(),
                        InIntrfcListDetail.getEleNm(), InIntrfcListDetail.getUserPrecProgrm(), InIntrfcListDetail.getCmmnProgrm(), InIntrfcListDetail.getUserProgrm(),
                        InIntrfcListDetail.getTmprColumn(), InIntrfcListDetail.getLastColumn(), InIntrfcListDetail.getLastColumnTrnsferYn(), InIntrfcListDetail.getHideYn(),
                        InIntrfcListDetail.getColumnTyCode(), InIntrfcListDetail.getColumnLt(), InIntrfcListDetail.getColumnDcmlpointLt(), InIntrfcListDetail.getColumnFrmatFom(),
                        InIntrfcListDetail.getColumnDfltVal(), InIntrfcListDetail.getColumnVrifyProgrmNm(), InIntrfcListDetail.getColumnRequiYn(), InIntrfcListDetail.getColumnPkYn(),
                        InIntrfcListDetail.getSmpleData(), InIntrfcListDetail.getUseYn(), InIntrfcListDetail.getUpdateBy(), InIntrfcListDetail.getColumnTrnsferGroupYn(),
                        InIntrfcListDetail.getRefrnCode(), InIntrfcListDetail.getSmpleColumnFixingYn()));
                }
                if (!haveDetail) {
                    System.out.println(intrfcListId + " doesnt have item");
                }
                sb.append("END;\n");
                sb.append("END;\n");
            }
            sb.append("END;\n");
            Path file = Paths.get(outputPath);

            Files.write(file, sb.toString().replaceAll("''", "NULL").getBytes("utf-8"));
        } finally {
            conn.close();
        }
    }

    public static Map<BigDecimal, List<InIntrfcListDetail>> loadDetailsDatabase(Connection conn) {

        List<Object> values = new ArrayList<Object>();
        String where = "";
        Map<BigDecimal, List<InIntrfcListDetail>> result = new HashMap<BigDecimal, List<InIntrfcListDetail>>();

        where += MapperResultSetToSelectedItem.getAndOrWhere(where) + "TENANCY_ID = ?";
        values.add(ExecutorDatabase.DEFAULT_TENANCY_ID);

        List<InIntrfcListDetail> loadDetail = (ArrayList<InIntrfcListDetail>) MapperResultSetToSelectedItem.map(conn, InIntrfcListDetail.class, where, values);

        for (InIntrfcListDetail list : loadDetail) {

            if (!result.containsKey(list.getIntrfcListId())) {
                result.put(list.getIntrfcListId(), new ArrayList<InIntrfcListDetail>());
            }
            result.get(list.getIntrfcListId()).add(list);
        }

        return result;
    }

}
