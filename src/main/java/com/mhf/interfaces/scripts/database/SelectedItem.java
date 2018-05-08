package com.mhf.interfaces.scripts.database;

/**
 * <p>
 * Interface for generic selects.
 * @see MapperResultSetToSelectedItem.
 *      </p>
 *
 * @author <a href="mailto:fernando.pedrazzanni@thomsonreuters.com">Fernando Santiago</a>
 *
 */
public interface SelectedItem {

    /**
     * Find query from table Oracle EBS.
     *
     * @return String SQL query
     */
    String getSelect();
}