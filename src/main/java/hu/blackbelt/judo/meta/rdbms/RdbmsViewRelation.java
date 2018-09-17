/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromAlias <em>From Alias</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToAlias <em>To Alias</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromField <em>From Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToField <em>To Field</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation()
 * @model
 * @generated
 */
public interface RdbmsViewRelation extends EObject {
    /**
     * Returns the value of the '<em><b>From Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From Alias</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From Alias</em>' reference.
     * @see #setFromAlias(RdbmsTableAlias)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation_FromAlias()
     * @model required="true"
     * @generated
     */
    RdbmsTableAlias getFromAlias();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromAlias <em>From Alias</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Alias</em>' reference.
     * @see #getFromAlias()
     * @generated
     */
    void setFromAlias(RdbmsTableAlias value);

    /**
     * Returns the value of the '<em><b>To Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To Alias</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To Alias</em>' reference.
     * @see #setToAlias(RdbmsTableAlias)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation_ToAlias()
     * @model required="true"
     * @generated
     */
    RdbmsTableAlias getToAlias();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToAlias <em>To Alias</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To Alias</em>' reference.
     * @see #getToAlias()
     * @generated
     */
    void setToAlias(RdbmsTableAlias value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>From Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From Field</em>' reference.
     * @see #setFromField(RdbmsIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation_FromField()
     * @model required="true"
     * @generated
     */
    RdbmsIdentifierField getFromField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromField <em>From Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Field</em>' reference.
     * @see #getFromField()
     * @generated
     */
    void setFromField(RdbmsIdentifierField value);

    /**
     * Returns the value of the '<em><b>To Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To Field</em>' reference.
     * @see #setToField(RdbmsIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsViewRelation_ToField()
     * @model required="true"
     * @generated
     */
    RdbmsIdentifierField getToField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToField <em>To Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To Field</em>' reference.
     * @see #getToField()
     * @generated
     */
    void setToField(RdbmsIdentifierField value);

} // RdbmsViewRelation
