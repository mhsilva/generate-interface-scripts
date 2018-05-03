package com.mhf.interfaces.scripts;

public class SqlConstants {

    public static String headerCall = "begin " + "pkg_data_conversion.merge_in_intrfc_list(p_tenancy_id                   => ''{0}''," +
        "                                         p_company_code                 => ''{1}''," + "                                         p_intrfc_code                  => ''{2}''," +
        "                                         p_intrfc_nm                    => ''{3}''," + "                                         p_intrfc_dc                    => ''{4}''," +
        "                                         p_tmpr_table                   => ''{5}''," + "                                         p_last_table                   => ''{6}''," +
        "                                         p_last_table_pk_column         => ''{7}''," + "                                         p_tmpr_prec_user_progrm        => ''{8}''," +
        "                                         p_tmpr_list_detail_user_progrm => ''{9}''," + "                                         p_last_user_prec_progrm        => ''{10}''," +
        "                                         p_last_cmmn_progrm             => ''{11}''," + "                                         p_last_cmmn_add_progrm         => ''{12}''," +
        "                                         p_last_user_progrm             => ''{13}''," + "                                         p_wsrv_progrm                  => ''{14}''," +
        "                                         p_ele_main_level               => ''{15}''," + "                                         p_frgn_column                  => ''{16}''," +
        "                                         p_frgn_column_progrm           => ''{17}''," + "                                         p_pk_ceck_yn                   => ''{18}''," +
        "                                         p_use_yn                       => ''{19}''," + "                                         p_update_by                    => ''{20}''," +
        "                                         p_intrfc_se_code               => ''{21}''," + "                                         p_smple_file_nm                => ''{22}''," +
        "                                         p_smple_file                   => ''{23}''," + "                                         p_excel_data_start_row_no      => ''{24}''," +
        "                                         p_smple_fixing_yn              => ''{25}''," + "                                         p_intrfc_end_date              => ''{26}'');" + "end;\n";

    public static String detailCall = "begin " + "pkg_data_conversion.merge_in_intrfc_list_detail(p_tenancy_id              => ''{0}''," +
        "                                                p_company_code            => ''{1}''," + "                                                p_intrfc_code             => ''{2}''," +
        "                                                p_intrfc_end_date         => ''{3}''," + "                                                p_intrfc_ty_code          => ''{4}''," +
        "                                                p_column_nm               => ''{5}''," + "                                                p_column_dc               => ''{6}''," +
        "                                                p_ele_course              => ''{7}''," + "                                                p_ele_nm                  => ''{8}''," +
        "                                                p_user_prec_progrm        => ''{9}''," + "                                                p_cmmn_progrm             => ''{10}''," +
        "                                                p_user_progrm             => ''{11}''," + "                                                p_tmpr_column             => ''{12}''," +
        "                                                p_last_column             => ''{13}''," + "                                                p_last_column_trnsfer_yn  => ''{14}''," +
        "                                                p_hide_yn                 => ''{15}''," + "                                                p_column_ty_code          => ''{16}''," +
        "                                                p_column_lt               => ''{17}''," + "                                                p_column_dcmlpoint_lt     => ''{18}''," +
        "                                                p_column_frmat_fom        => ''{19}''," + "                                                p_column_dflt_val         => ''{20}''," +
        "                                                p_column_vrify_progrm_nm  => ''{21}''," + "                                                p_column_requi_yn         => ''{22}''," +
        "                                                p_column_pk_yn            => ''{23}''," + "                                                p_smple_data              => ''{24}''," +
        "                                                p_use_yn                  => ''{25}''," + "                                                p_update_by               => ''{26}''," +
        "                                                p_column_trnsfer_group_yn => ''{27}''," + "                                                p_refrn_code              => ''{28}''," +
        "                                                p_smple_column_fixing_yn  => ''{29}'');" + "end;\n";
}
