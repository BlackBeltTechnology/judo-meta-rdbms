/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsUniqueConstraint()
 * @model
 * @generated
 */
public interface RdbmsUniqueConstraint extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Table</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getUniqueConstraints <em>Unique Constraints</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table</em>' container reference.
     * @see #setTable(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsUniqueConstraint_Table()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getUniqueConstraints
     * @model opposite="uniqueConstraints" required="true" transient="false"
     * @generated
     */
    RdbmsTable getTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable <em>Table</em>}' container reference.
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsUniqueConstraint_Fields()
     * @model required="true"
     * @generated
     */
    EList<RdbmsField> getFields();

} // RdbmsUniqueConstraint
