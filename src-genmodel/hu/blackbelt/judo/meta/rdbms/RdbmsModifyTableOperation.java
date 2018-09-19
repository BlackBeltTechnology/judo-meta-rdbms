/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Table Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getCreateFieldOperations <em>Create Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getModifyFieldOperations <em>Modify Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getDeleteFieldOperations <em>Delete Field Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getPreviousTable <em>Previous Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#isNameChanged <em>Name Changed</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation()
 * @model
 * @generated
 */
public interface RdbmsModifyTableOperation extends RdbmsTableOperation {
    /**
     * Returns the value of the '<em><b>Create Field Operations</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Create Field Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Create Field Operations</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation_CreateFieldOperations()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsCreateFieldOperation> getCreateFieldOperations();

    /**
     * Returns the value of the '<em><b>Modify Field Operations</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modify Field Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modify Field Operations</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation_ModifyFieldOperations()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsModifyFieldOperation> getModifyFieldOperations();

    /**
     * Returns the value of the '<em><b>Delete Field Operations</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delete Field Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delete Field Operations</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation_DeleteFieldOperations()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsDeleteFieldOperation> getDeleteFieldOperations();

    /**
     * Returns the value of the '<em><b>Previous Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Previous Table</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Previous Table</em>' reference.
     * @see #setPreviousTable(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation_PreviousTable()
     * @model required="true"
     * @generated
     */
    RdbmsTable getPreviousTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getPreviousTable <em>Previous Table</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Previous Table</em>' reference.
     * @see #getPreviousTable()
     * @generated
     */
    void setPreviousTable(RdbmsTable value);

    /**
     * Returns the value of the '<em><b>Name Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name Changed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name Changed</em>' attribute.
     * @see #setNameChanged(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModifyTableOperation_NameChanged()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isNameChanged();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#isNameChanged <em>Name Changed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name Changed</em>' attribute.
     * @see #isNameChanged()
     * @generated
     */
    void setNameChanged(boolean value);

} // RdbmsModifyTableOperation
