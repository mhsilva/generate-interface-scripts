package com.mhf.interfaces.scripts.database;

import java.math.BigDecimal;
import java.util.Calendar;

public class InIntrfcList implements SelectedItem {

    public String getSelect() {
        return "SELECT * FROM   IN_INTRFC_LIST";
    }

    private String companyCode;

    private BigDecimal createBy;

    private Calendar createDate;

    private BigDecimal eleMainLevel;

    private BigDecimal excelDataStartRowNo;

    private String frgnColumn;

    private String frgnColumnProgrm;

    private String intrfcCode;

    private String intrfcDc;

    private String intrfcEndDate;

    private BigDecimal intrfcListId;

    private String intrfcNm;

    private String intrfcSeCode;

    private String lastCmmnAddProgrm;

    private String lastCmmnProgrm;

    private String lastTable;

    private String lastTablePkColumn;

    private String lastUserPrecProgrm;

    private String lastUserProgrm;

    private String pkCeckYn;

    private oracle.jdbc.OracleBlob smpleFile;

    private String smpleFileNm;

    private String smpleFixingYn;

    private String tenancyId;

    private String tmprListDetailUserProgrm;

    private String tmprPrecUserProgrm;

    private String tmprTable;

    private BigDecimal updateBy;

    private Calendar updateDate;

    private String useYn;

    private String wsrvProgrm;

    /**
     * Gets the attribute companyCode.
     *
     * @return companyCode.
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * Sets the attribute companyCode.
     *
     * @param companyCode to set the companyCode.
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * Gets the attribute createBy.
     *
     * @return createBy.
     */
    public BigDecimal getCreateBy() {
        return createBy;
    }

    /**
     * Sets the attribute createBy.
     *
     * @param createBy to set the createBy.
     */
    public void setCreateBy(BigDecimal createBy) {
        this.createBy = createBy;
    }

    /**
     * Gets the attribute createDate.
     *
     * @return createDate.
     */
    public Calendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the attribute createDate.
     *
     * @param createDate to set the createDate.
     */
    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets the attribute eleMainLevel.
     *
     * @return eleMainLevel.
     */
    public BigDecimal getEleMainLevel() {
        return eleMainLevel;
    }

    /**
     * Sets the attribute eleMainLevel.
     *
     * @param eleMainLevel to set the eleMainLevel.
     */
    public void setEleMainLevel(BigDecimal eleMainLevel) {
        this.eleMainLevel = eleMainLevel;
    }

    /**
     * Gets the attribute excelDataStartRowNo.
     *
     * @return excelDataStartRowNo.
     */
    public BigDecimal getExcelDataStartRowNo() {
        return excelDataStartRowNo;
    }

    /**
     * Sets the attribute excelDataStartRowNo.
     *
     * @param excelDataStartRowNo to set the excelDataStartRowNo.
     */
    public void setExcelDataStartRowNo(BigDecimal excelDataStartRowNo) {
        this.excelDataStartRowNo = excelDataStartRowNo;
    }

    /**
     * Gets the attribute frgnColumn.
     *
     * @return frgnColumn.
     */
    public String getFrgnColumn() {
        return frgnColumn;
    }

    /**
     * Sets the attribute frgnColumn.
     *
     * @param frgnColumn to set the frgnColumn.
     */
    public void setFrgnColumn(String frgnColumn) {
        this.frgnColumn = frgnColumn;
    }

    /**
     * Gets the attribute frgnColumnProgrm.
     *
     * @return frgnColumnProgrm.
     */
    public String getFrgnColumnProgrm() {
        return frgnColumnProgrm;
    }

    /**
     * Sets the attribute frgnColumnProgrm.
     *
     * @param frgnColumnProgrm to set the frgnColumnProgrm.
     */
    public void setFrgnColumnProgrm(String frgnColumnProgrm) {
        this.frgnColumnProgrm = frgnColumnProgrm;
    }

    /**
     * Gets the attribute intrfcCode.
     *
     * @return intrfcCode.
     */
    public String getIntrfcCode() {
        return intrfcCode;
    }

    /**
     * Sets the attribute intrfcCode.
     *
     * @param intrfcCode to set the intrfcCode.
     */
    public void setIntrfcCode(String intrfcCode) {
        this.intrfcCode = intrfcCode;
    }

    /**
     * Gets the attribute intrfcDc.
     *
     * @return intrfcDc.
     */
    public String getIntrfcDc() {
        return intrfcDc;
    }

    /**
     * Sets the attribute intrfcDc.
     *
     * @param intrfcDc to set the intrfcDc.
     */
    public void setIntrfcDc(String intrfcDc) {
        this.intrfcDc = intrfcDc;
    }

    /**
     * Gets the attribute intrfcEndDate.
     *
     * @return intrfcEndDate.
     */
    public String getIntrfcEndDate() {
        return intrfcEndDate;
    }

    /**
     * Sets the attribute intrfcEndDate.
     *
     * @param intrfcEndDate to set the intrfcEndDate.
     */
    public void setIntrfcEndDate(String intrfcEndDate) {
        this.intrfcEndDate = intrfcEndDate;
    }

    /**
     * Gets the attribute intrfcListId.
     *
     * @return intrfcListId.
     */
    public BigDecimal getIntrfcListId() {
        return intrfcListId;
    }

    /**
     * Sets the attribute intrfcListId.
     *
     * @param intrfcListId to set the intrfcListId.
     */
    public void setIntrfcListId(BigDecimal intrfcListId) {
        this.intrfcListId = intrfcListId;
    }

    /**
     * Gets the attribute intrfcNm.
     *
     * @return intrfcNm.
     */
    public String getIntrfcNm() {
        return intrfcNm;
    }

    /**
     * Sets the attribute intrfcNm.
     *
     * @param intrfcNm to set the intrfcNm.
     */
    public void setIntrfcNm(String intrfcNm) {
        this.intrfcNm = intrfcNm;
    }

    /**
     * Gets the attribute intrfcSeCode.
     *
     * @return intrfcSeCode.
     */
    public String getIntrfcSeCode() {
        return intrfcSeCode;
    }

    /**
     * Sets the attribute intrfcSeCode.
     *
     * @param intrfcSeCode to set the intrfcSeCode.
     */
    public void setIntrfcSeCode(String intrfcSeCode) {
        this.intrfcSeCode = intrfcSeCode;
    }

    /**
     * Gets the attribute lastCmmnAddProgrm.
     *
     * @return lastCmmnAddProgrm.
     */
    public String getLastCmmnAddProgrm() {
        return lastCmmnAddProgrm;
    }

    /**
     * Sets the attribute lastCmmnAddProgrm.
     *
     * @param lastCmmnAddProgrm to set the lastCmmnAddProgrm.
     */
    public void setLastCmmnAddProgrm(String lastCmmnAddProgrm) {
        this.lastCmmnAddProgrm = lastCmmnAddProgrm;
    }

    /**
     * Gets the attribute lastCmmnProgrm.
     *
     * @return lastCmmnProgrm.
     */
    public String getLastCmmnProgrm() {
        return lastCmmnProgrm;
    }

    /**
     * Sets the attribute lastCmmnProgrm.
     *
     * @param lastCmmnProgrm to set the lastCmmnProgrm.
     */
    public void setLastCmmnProgrm(String lastCmmnProgrm) {
        this.lastCmmnProgrm = lastCmmnProgrm;
    }

    /**
     * Gets the attribute lastTable.
     *
     * @return lastTable.
     */
    public String getLastTable() {
        return lastTable;
    }

    /**
     * Sets the attribute lastTable.
     *
     * @param lastTable to set the lastTable.
     */
    public void setLastTable(String lastTable) {
        this.lastTable = lastTable;
    }

    /**
     * Gets the attribute lastTablePkColumn.
     *
     * @return lastTablePkColumn.
     */
    public String getLastTablePkColumn() {
        return lastTablePkColumn;
    }

    /**
     * Sets the attribute lastTablePkColumn.
     *
     * @param lastTablePkColumn to set the lastTablePkColumn.
     */
    public void setLastTablePkColumn(String lastTablePkColumn) {
        this.lastTablePkColumn = lastTablePkColumn;
    }

    /**
     * Gets the attribute lastUserPrecProgrm.
     *
     * @return lastUserPrecProgrm.
     */
    public String getLastUserPrecProgrm() {
        return lastUserPrecProgrm;
    }

    /**
     * Sets the attribute lastUserPrecProgrm.
     *
     * @param lastUserPrecProgrm to set the lastUserPrecProgrm.
     */
    public void setLastUserPrecProgrm(String lastUserPrecProgrm) {
        this.lastUserPrecProgrm = lastUserPrecProgrm;
    }

    /**
     * Gets the attribute lastUserProgrm.
     *
     * @return lastUserProgrm.
     */
    public String getLastUserProgrm() {
        return lastUserProgrm;
    }

    /**
     * Sets the attribute lastUserProgrm.
     *
     * @param lastUserProgrm to set the lastUserProgrm.
     */
    public void setLastUserProgrm(String lastUserProgrm) {
        this.lastUserProgrm = lastUserProgrm;
    }

    /**
     * Gets the attribute pkCeckYn.
     *
     * @return pkCeckYn.
     */
    public String getPkCeckYn() {
        return pkCeckYn;
    }

    /**
     * Sets the attribute pkCeckYn.
     *
     * @param pkCeckYn to set the pkCeckYn.
     */
    public void setPkCeckYn(String pkCeckYn) {
        this.pkCeckYn = pkCeckYn;
    }

    /**
     * Gets the attribute smpleFileNm.
     *
     * @return smpleFileNm.
     */
    public String getSmpleFileNm() {
        return smpleFileNm;
    }

    /**
     * Sets the attribute smpleFileNm.
     *
     * @param smpleFileNm to set the smpleFileNm.
     */
    public void setSmpleFileNm(String smpleFileNm) {
        this.smpleFileNm = smpleFileNm;
    }

    /**
     * Gets the attribute smpleFixingYn.
     *
     * @return smpleFixingYn.
     */
    public String getSmpleFixingYn() {
        return smpleFixingYn;
    }

    /**
     * Sets the attribute smpleFixingYn.
     *
     * @param smpleFixingYn to set the smpleFixingYn.
     */
    public void setSmpleFixingYn(String smpleFixingYn) {
        this.smpleFixingYn = smpleFixingYn;
    }

    /**
     * Gets the attribute tenancyId.
     *
     * @return tenancyId.
     */
    public String getTenancyId() {
        return tenancyId;
    }

    /**
     * Sets the attribute tenancyId.
     *
     * @param tenancyId to set the tenancyId.
     */
    public void setTenancyId(String tenancyId) {
        this.tenancyId = tenancyId;
    }

    /**
     * Gets the attribute tmprListDetailUserProgrm.
     *
     * @return tmprListDetailUserProgrm.
     */
    public String getTmprListDetailUserProgrm() {
        return tmprListDetailUserProgrm;
    }

    /**
     * Sets the attribute tmprListDetailUserProgrm.
     *
     * @param tmprListDetailUserProgrm to set the tmprListDetailUserProgrm.
     */
    public void setTmprListDetailUserProgrm(String tmprListDetailUserProgrm) {
        this.tmprListDetailUserProgrm = tmprListDetailUserProgrm;
    }

    /**
     * Gets the attribute tmprPrecUserProgrm.
     *
     * @return tmprPrecUserProgrm.
     */
    public String getTmprPrecUserProgrm() {
        return tmprPrecUserProgrm;
    }

    /**
     * Sets the attribute tmprPrecUserProgrm.
     *
     * @param tmprPrecUserProgrm to set the tmprPrecUserProgrm.
     */
    public void setTmprPrecUserProgrm(String tmprPrecUserProgrm) {
        this.tmprPrecUserProgrm = tmprPrecUserProgrm;
    }

    /**
     * Gets the attribute tmprTable.
     *
     * @return tmprTable.
     */
    public String getTmprTable() {
        return tmprTable;
    }

    /**
     * Sets the attribute tmprTable.
     *
     * @param tmprTable to set the tmprTable.
     */
    public void setTmprTable(String tmprTable) {
        this.tmprTable = tmprTable;
    }

    /**
     * Gets the attribute updateBy.
     *
     * @return updateBy.
     */
    public BigDecimal getUpdateBy() {
        return updateBy;
    }

    /**
     * Sets the attribute updateBy.
     *
     * @param updateBy to set the updateBy.
     */
    public void setUpdateBy(BigDecimal updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * Gets the attribute updateDate.
     *
     * @return updateDate.
     */
    public Calendar getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the attribute updateDate.
     *
     * @param updateDate to set the updateDate.
     */
    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets the attribute useYn.
     *
     * @return useYn.
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * Sets the attribute useYn.
     *
     * @param useYn to set the useYn.
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * Gets the attribute wsrvProgrm.
     *
     * @return wsrvProgrm.
     */
    public String getWsrvProgrm() {
        return wsrvProgrm;
    }

    /**
     * Sets the attribute wsrvProgrm.
     *
     * @param wsrvProgrm to set the wsrvProgrm.
     */
    public void setWsrvProgrm(String wsrvProgrm) {
        this.wsrvProgrm = wsrvProgrm;
    }

    /**
     * Gets the attribute smpleFile.
     *
     * @return smpleFile.
     */
    public oracle.jdbc.OracleBlob getSmpleFile() {
        return smpleFile;
    }

    /**
     * Sets the attribute smpleFile.
     *
     * @param smpleFile to set the smpleFile.
     */
    public void setSmpleFile(oracle.jdbc.OracleBlob smpleFile) {
        this.smpleFile = smpleFile;
    }

}
