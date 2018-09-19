/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#getField <em>Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#isReviewRequired <em>Review Required</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldOperation()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsFieldOperation extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field</em>' reference.
     * @see #setField(RdbmsField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldOperation_Field()
     * @model required="true"
     * @generated
     */
    RdbmsField getField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#getField <em>Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field</em>' reference.
     * @see #getField()
     * @generated
     */
    void setField(RdbmsField value);

    /**
     * Returns the value of the '<em><b>Review Required</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Review Required</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Review Required</em>' attribute.
     * @see #setReviewRequired(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldOperation_ReviewRequired()
     * @model default="false" required="true"
     * @generated
     */
    boolean isReviewRequired();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#isReviewRequired <em>Review Required</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Review Required</em>' attribute.
     * @see #isReviewRequired()
     * @generated
     */
    void setReviewRequired(boolean value);

} // RdbmsFieldOperation
