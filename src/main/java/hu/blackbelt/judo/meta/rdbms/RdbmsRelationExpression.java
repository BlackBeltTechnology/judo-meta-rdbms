/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsRelationExpression()
 * @model
 * @generated
 */
public interface RdbmsRelationExpression extends RdbmsExpression {
    /**
     * Returns the value of the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field</em>' reference.
     * @see #setField(RdbmsViewAliasField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsRelationExpression_Field()
     * @model required="true"
     * @generated
     */
    RdbmsViewAliasField getField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression#getField <em>Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field</em>' reference.
     * @see #getField()
     * @generated
     */
    void setField(RdbmsViewAliasField value);

} // RdbmsRelationExpression
