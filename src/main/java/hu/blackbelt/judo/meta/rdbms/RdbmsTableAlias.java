/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Alias</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView <em>View</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTableAlias()
 * @model
 * @generated
 */
public interface RdbmsTableAlias extends RdbmsElement {
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTableAlias_Table()
     * @model required="true"
     * @generated
     */
    RdbmsTable getTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getTable <em>Table</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table</em>' reference.
     * @see #getTable()
     * @generated
     */
    void setTable(RdbmsTable value);

    /**
     * Returns the value of the '<em><b>View</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getTables <em>Tables</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View</em>' container reference.
     * @see #setView(RdbmsView)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTableAlias_View()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getTables
     * @model opposite="tables" required="true" transient="false"
     * @generated
     */
    RdbmsView getView();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView <em>View</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>View</em>' container reference.
     * @see #getView()
     * @generated
     */
    void setView(RdbmsView value);

} // RdbmsTableAlias
