/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryTable <em>Primary Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getOriginUuid <em>Origin Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getRelations <em>Relations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryIdentifierField <em>Primary Identifier Field</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView()
 * @model
 * @generated
 */
public interface RdbmsView extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_Fields()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView
     * @model opposite="view" containment="true"
     * @generated
     */
    EList<RdbmsViewField> getFields();

    /**
     * Returns the value of the '<em><b>Primary Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Table</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Table</em>' reference.
     * @see #setPrimaryTable(RdbmsTableAlias)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_PrimaryTable()
     * @model required="true"
     * @generated
     */
    RdbmsTableAlias getPrimaryTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryTable <em>Primary Table</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Table</em>' reference.
     * @see #getPrimaryTable()
     * @generated
     */
    void setPrimaryTable(RdbmsTableAlias value);

    /**
     * Returns the value of the '<em><b>Origin Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Origin Uuid</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Origin Uuid</em>' attribute.
     * @see #setOriginUuid(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_OriginUuid()
     * @model
     * @generated
     */
    String getOriginUuid();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getOriginUuid <em>Origin Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Origin Uuid</em>' attribute.
     * @see #getOriginUuid()
     * @generated
     */
    void setOriginUuid(String value);

    /**
     * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Relations</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_Relations()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsViewRelation> getRelations();

    /**
     * Returns the value of the '<em><b>Primary Identifier Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Identifier Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Identifier Field</em>' reference.
     * @see #setPrimaryIdentifierField(RdbmsViewIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_PrimaryIdentifierField()
     * @model required="true"
     * @generated
     */
    RdbmsViewIdentifierField getPrimaryIdentifierField();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryIdentifierField <em>Primary Identifier Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Identifier Field</em>' reference.
     * @see #getPrimaryIdentifierField()
     * @generated
     */
    void setPrimaryIdentifierField(RdbmsViewIdentifierField value);

    /**
     * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tables</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsView_Tables()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView
     * @model opposite="view" containment="true" required="true"
     * @generated
     */
    EList<RdbmsTableAlias> getTables();

} // RdbmsView
