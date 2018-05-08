package com.mhf.interfaces.scripts.database;

import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * <p>
 * Select records from database based in select from POJO.
 * This class map automatic attibutes x fiedls from database
 * @see SelectedItem
 *      </p>
 *
 * @author <a href="mailto:fernando.pedrazzanni@thomsonreuters.com">Fernando Santiago</a>
 *
 */
public final class MapperResultSetToSelectedItem {

    /**
     * Constructor.
     */
    private MapperResultSetToSelectedItem() {

    }

    /**
     * Map select record set from database to POJO.
     * 
     * @param conn current connection
     * @param classObjetoSfwSelectedItem object implements {@link SelectedItem}
     * @param filter fields where from sql query
     * @param filterValues where from sql query
     * @param <T> generic object.
     * @return object mapped
     */
    public static <T> List<T> map(Connection conn,
        Class<T> classObjetoSfwSelectedItem,
        String filter,
        Object... filterValues) {
        List<Object> values = new ArrayList<Object>();
        if (filterValues != null) {
            for (int i = 0; i < filterValues.length; i++) {
                Object object = filterValues[i];
                values.add(object);
            }
        }
        return map(conn, classObjetoSfwSelectedItem, filter, values);
    }

    /**
     * Map select record set from database to POJO.
     * 
     * @param conn current connection
     * @param classObjetoSfwSelectedItem object implements {@link SelectedItem}
     * @param filter fields where from sql query
     * @param filterValues where from sql query
     * @param <T> generic object.
     * @return object mapped
     */
    public static <T> List<T> map(Connection conn,
        Class<T> classObjetoSfwSelectedItem,
        String filter,
        List<Object> filterValues) {
        List<T> listReturn = new ArrayList<T>();
        try {
            T sfwData = classObjetoSfwSelectedItem.newInstance();
            PreparedStatement ps = conn.prepareStatement(((SelectedItem) sfwData).getSelect() + filter);

            preparedStatmentMap(ps, filterValues);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sfwData = classObjetoSfwSelectedItem.newInstance();
                map(rs, sfwData);

                listReturn.add(sfwData);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listReturn;
    }

    public static <T> List<T> mapAllRecords(Connection conn,
        Class<T> classObjetoSfwSelectedItem) {
        List<T> listReturn = new ArrayList<T>();
        try {
            T sfwData = classObjetoSfwSelectedItem.newInstance();
            PreparedStatement ps = conn.prepareStatement(((SelectedItem) sfwData).getSelect());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sfwData = classObjetoSfwSelectedItem.newInstance();
                map(rs, sfwData);

                listReturn.add(sfwData);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listReturn;
    }

    /**
     * Map ResultSet for Object.
     * 
     * @param resultSet result set from database
     * @param objectToSet generic object to bem map
     */
    public static void map(ResultSet resultSet,
        Object objectToSet) {
        map(resultSet, objectToSet, "");
    }

    /**
     * Map ResultSet to Object.
     * 
     * @param resultSet from database
     * @param objectToSet generic Object
     * @param fieldPrefix field Prefix
     */
    public static void map(ResultSet resultSet,
        Object objectToSet,
        String fieldPrefix) {
        try {
            ResultSetMetaData rsm = resultSet.getMetaData();
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                String methodName = toPojoSetStyle(toCamelCase(rsm.getColumnName(i)));
                @SuppressWarnings("rawtypes")
                Class paramClass = Class.forName(rsm.getColumnClassName(i));
                if (Timestamp.class.isAssignableFrom(paramClass)) {
                    Method method = objectToSet.getClass().getMethod(methodName, new Class[] { Calendar.class });

                    Timestamp wsValue = (Timestamp) resultSet.getObject(i);
                    if (wsValue != null) {
                        GregorianCalendar gc = new GregorianCalendar();
                        gc.setTimeInMillis(wsValue.getTime());
                        method.invoke(objectToSet, new Object[] { gc });
                    } else {
                        method.invoke(objectToSet, new Object[] { null });
                    }
                } else if (Clob.class.isAssignableFrom(paramClass)) {
                    Method method = objectToSet.getClass().getMethod(methodName, new Class[] { String.class });
                    if (resultSet.getObject(i) == null) {
                        method.invoke(objectToSet, new Object[] { resultSet.getObject(i) });
                    } else {
                        Clob clob = (Clob) resultSet.getObject(i);
                        Reader r = clob.getCharacterStream();

                        StringBuilder sb = new StringBuilder();
                        int c;
                        while ((c = r.read()) != -1) {
                            sb.append((char) c);
                        }
                        clob.free();
                        method.invoke(objectToSet, new Object[] { sb.toString() });
                    }
                } else {
                    Method method = objectToSet.getClass().getMethod(methodName, new Class[] { paramClass });
                    method.invoke(objectToSet, new Object[] { resultSet.getObject(i) });
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Map values.
     * 
     * @param ps prepare Statement
     * @param values to bem mapped
     * @throws SQLException any SQL eXCEPTION
     */
    public static void preparedStatmentMap(PreparedStatement ps,
        List<Object> values) throws SQLException {
        int i = 1;
        for (Object object : values) {
            if ((object instanceof Calendar)) {
                object = new Timestamp(((Calendar) object).getTimeInMillis());
            }
            ps.setObject(i++, object);
        }
    }

    /**
     * Return clooum name to lower case.
     * 
     * @param columnName column name
     * @return Column Name to lowe case
     */
    public static String toCamelCase(String columnName) {
        String result = "";

        char[] column = columnName.toCharArray();
        boolean upper = false;
        for (int i = 0; i < column.length; i++) {
            char c = column[i];
            if (result.length() == 0) {
                result = result + Character.toLowerCase(c);
                upper = false;
            } else if ("_".equals(String.valueOf(c))) {
                upper = true;
            } else if (upper) {
                upper = false;
                result = result + Character.toUpperCase(c);
            } else {
                result = result + Character.toLowerCase(c);
            }
        }
        return result;
    }

    /**
     * Return the original string on database style.
     * e.g. 1: OsgtItTableName -> OSGT_IT_TABLE_NAME.
     * e.g. 2: tableField -> TABLE_FIELD.
     * @param property
     * @return result
     */
    public static String toDatabaseStyle(String property) {
        String result = "";
        char[] column = property.toCharArray();
        for (int i = 0; i < column.length; i++) {
            char c = column[i];
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else if (Character.isUpperCase(c) && i != 0) {
                result += "_" + c;
            } else if (i == 0) {
                result += c;
            } else if (Character.isDigit(c)) {
                result += c;
            }
        }
        return result;
    }

    /**
     * Return set from attribute.
     * 
     * @param property attribute name
     * @return set + attribute name
     */
    public static String toPojoSetStyle(String property) {
        return toPojoStyle(property, "set");
    }

    /**
     * Return get from attribute.
     * 
     * @param property attribute name
     * @return get + attribute name.
     */
    public static String toPojoGetStyle(String property) {
        return toPojoStyle(property, "get");
    }

    /**
     * Retrun attribute in Camel Case format.
     * 
     * @param property attribute name
     * @param prefix from attribute
     * @return string in calem case format.
     */
    private static String toPojoStyle(String property,
        String prefix) {
        String result = prefix;
        if ((!Character.isLowerCase(property.charAt(0))) || (!Character.isUpperCase(property.charAt(1)))) {
            result = result + property.substring(0, 1).toUpperCase();
            result = result + property.substring(1, property.length());
        } else {
            result = result + property;
        }
        return result;
    }

    /**
     * Retun where from SQL query.
     * 
     * @param select query
     * @return where from sql query
     */
    public static String getAndOrWhere(String select) {
        if ((select != null) && (select.trim().toUpperCase().startsWith("WHERE"))) {
            return " AND ";
        }
        return " WHERE ";
    }

    /**
     * Get value for column.
     * 
     * @param databaseColumnName name from column
     * @param value from database
     * @return result Object from POJO converted
     * @throws SecurityException SecurityException
     * @throws NoSuchMethodException NoSuchMethodException
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws IllegalAccessException IllegalAccessException
     * @throws InvocationTargetException InvocationTargetException
     */
    public static Object getValue(String databaseColumnName,
        Object value) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        String method = toPojoGetStyle(toCamelCase(databaseColumnName));
        Method m = value.getClass().getDeclaredMethod(method);
        Object result = m.invoke(value);
        return result;
    }
}