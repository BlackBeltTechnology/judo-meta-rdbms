/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getValues <em>Values</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getView <em>View</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecord()
 * @model
 * @generated
 */
public interface RdbmsViewRecord extends EObject {
    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecord_Values()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsViewRecordValue> getValues();

    /**
     * Returns the value of the '<em><b>View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View</em>' reference.
     * @see #setView(RdbmsView)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecord_View()
     * @model required="true"
     * @generated
     */
    RdbmsView getView();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getView <em>View</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>View</em>' reference.
     * @see #getView()
     * @generated
     */
    void setView(RdbmsView value);

} // RdbmsViewRecord
