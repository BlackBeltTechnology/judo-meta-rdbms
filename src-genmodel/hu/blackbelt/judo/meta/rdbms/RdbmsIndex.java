/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#isUnique <em>Unique</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIndex()
 * @model
 * @generated
 */
public interface RdbmsIndex extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Table</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getIndexes <em>Indexes</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table</em>' container reference.
     * @see #setTable(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIndex_Table()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getIndexes
     * @model opposite="indexes" required="true" transient="false"
     * @generated
     */
    RdbmsTable getTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable <em>Table</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table</em>' container reference.
     * @see #getTable()
     * @generated
     */
    void setTable(RdbmsTable value);

    /**
     * Returns the value of the '<em><b>Fields</b></em>' reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsField}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fields</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIndex_Fields()
     * @model required="true"
     * @generated
     */
    EList<RdbmsField> getFields();

    /**
     * Returns the value of the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unique</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unique</em>' attribute.
     * @see #setUnique(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIndex_Unique()
     * @model required="true"
     * @generated
     */
    boolean isUnique();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#isUnique <em>Unique</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Unique</em>' attribute.
     * @see #isUnique()
     * @generated
     */
    void setUnique(boolean value);

} // RdbmsIndex
