/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTableOperation()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsTableOperation extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table</em>' reference.
     * @see #setTable(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTableOperation_Table()
     * @model required="true"
     * @generated
     */
    RdbmsTable getTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation#getTable <em>Table</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table</em>' reference.
     * @see #getTable()
     * @generated
     */
    void setTable(RdbmsTable value);

} // RdbmsTableOperation
