/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getFields <em>Fields</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getUniqueConstraints <em>Unique Constraints</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable()
 * @model
 * @generated
 */
public interface RdbmsTable extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsField}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable_Fields()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable
     * @model opposite="table" containment="true"
     * @generated
     */
    EList<RdbmsField> getFields();

    /**
     * Returns the value of the '<em><b>Unique Constraints</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unique Constraints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unique Constraints</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable_UniqueConstraints()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable
     * @model opposite="table" containment="true"
     * @generated
     */
    EList<RdbmsUniqueConstraint> getUniqueConstraints();

    /**
     * Returns the value of the '<em><b>Primary Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Key</em>' reference.
     * @see #setPrimaryKey(RdbmsIdentifierField)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable_PrimaryKey()
     * @model required="true"
     * @generated
     */
    RdbmsIdentifierField getPrimaryKey();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getPrimaryKey <em>Primary Key</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Key</em>' reference.
     * @see #getPrimaryKey()
     * @generated
     */
    void setPrimaryKey(RdbmsIdentifierField value);

    /**
     * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Indexes</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable_Indexes()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable
     * @model opposite="table" containment="true"
     * @generated
     */
    EList<RdbmsIndex> getIndexes();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see #setParent(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsTable_Parent()
     * @model
     * @generated
     */
    RdbmsTable getParent();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getParent <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent(RdbmsTable value);

} // RdbmsTable
