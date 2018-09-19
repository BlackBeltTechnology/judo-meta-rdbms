/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Record Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValue <em>Value</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getIdentifierField <em>Identifier Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValueField <em>Value Field</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecordValue()
 * @model
 * @generated
 */
public interface RdbmsViewRecordValue extends EObject {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecordValue_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Identifier Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Identifier Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Identifier Field</em>' reference.
     * @see #setIdentifierField(RdbmsViewIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecordValue_IdentifierField()
     * @model
     * @generated
     */
    RdbmsViewIdentifierField getIdentifierField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getIdentifierField <em>Identifier Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Identifier Field</em>' reference.
     * @see #getIdentifierField()
     * @generated
     */
    void setIdentifierField(RdbmsViewIdentifierField value);

    /**
     * Returns the value of the '<em><b>Value Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Field</em>' reference.
     * @see #setValueField(RdbmsViewValueField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRecordValue_ValueField()
     * @model
     * @generated
     */
    RdbmsViewValueField getValueField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValueField <em>Value Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Field</em>' reference.
     * @see #getValueField()
     * @generated
     */
    void setValueField(RdbmsViewValueField value);

} // RdbmsViewRecordValue
