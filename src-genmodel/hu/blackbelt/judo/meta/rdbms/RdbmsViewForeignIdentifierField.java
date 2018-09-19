/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Foreign Identifier Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField#getReferenceIdentifier <em>Reference Identifier</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewForeignIdentifierField()
 * @model
 * @generated
 */
public interface RdbmsViewForeignIdentifierField extends RdbmsViewTableField {
    /**
     * Returns the value of the '<em><b>Reference Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference Identifier</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference Identifier</em>' reference.
     * @see #setReferenceIdentifier(RdbmsViewIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewForeignIdentifierField_ReferenceIdentifier()
     * @model required="true"
     * @generated
     */
    RdbmsViewIdentifierField getReferenceIdentifier();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField#getReferenceIdentifier <em>Reference Identifier</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference Identifier</em>' reference.
     * @see #getReferenceIdentifier()
     * @generated
     */
    void setReferenceIdentifier(RdbmsViewIdentifierField value);

} // RdbmsViewForeignIdentifierField
