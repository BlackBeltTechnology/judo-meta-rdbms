/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Alias Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewAliasField()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsViewAliasField extends RdbmsViewTableField {
    /**
     * Returns the value of the '<em><b>Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alias</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alias</em>' reference.
     * @see #setAlias(RdbmsTableAlias)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewAliasField_Alias()
     * @model required="true"
     * @generated
     */
    RdbmsTableAlias getAlias();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField#getAlias <em>Alias</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alias</em>' reference.
     * @see #getAlias()
     * @generated
     */
    void setAlias(RdbmsTableAlias value);

} // RdbmsViewAliasField
