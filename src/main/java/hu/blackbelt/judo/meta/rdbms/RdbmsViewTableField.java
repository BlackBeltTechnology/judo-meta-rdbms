/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Table Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#getTableField <em>Table Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#isForeign <em>Foreign</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewTableField()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsViewTableField extends RdbmsViewField {
    /**
     * Returns the value of the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table Field</em>' reference.
     * @see #setTableField(RdbmsField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewTableField_TableField()
     * @model required="true"
     * @generated
     */
    RdbmsField getTableField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#getTableField <em>Table Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table Field</em>' reference.
     * @see #getTableField()
     * @generated
     */
    void setTableField(RdbmsField value);

    /**
     * Returns the value of the '<em><b>Foreign</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreign</em>' attribute.
     * @see #setForeign(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewTableField_Foreign()
     * @model default="false" required="true"
     * @generated
     */
    boolean isForeign();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#isForeign <em>Foreign</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreign</em>' attribute.
     * @see #isForeign()
     * @generated
     */
    void setForeign(boolean value);

} // RdbmsViewTableField
