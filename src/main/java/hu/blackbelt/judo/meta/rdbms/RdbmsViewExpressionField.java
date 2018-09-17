/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Expression Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewExpressionField()
 * @model
 * @generated
 */
public interface RdbmsViewExpressionField extends RdbmsViewField {
    /**
     * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsExpression}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expressions</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewExpressionField_Expressions()
     * @model containment="true" required="true"
     * @generated
     */
    EList<RdbmsExpression> getExpressions();

    /**
     * Returns the value of the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' attribute.
     * @see #setExpression(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewExpressionField_Expression()
     * @model required="true"
     * @generated
     */
    String getExpression();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpression <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' attribute.
     * @see #getExpression()
     * @generated
     */
    void setExpression(String value);

} // RdbmsViewExpressionField
