/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsFieldTypes <em>Rdbms Field Types</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsTables <em>Rdbms Tables</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsViews <em>Rdbms Views</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getVersion <em>Version</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getTableOperations <em>Table Operations</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getViewRecords <em>View Records</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel()
 * @model
 * @generated
 */
public interface RdbmsModel extends EObject {
    /**
     * Returns the value of the '<em><b>Rdbms Field Types</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rdbms Field Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rdbms Field Types</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_RdbmsFieldTypes()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsFieldType> getRdbmsFieldTypes();

    /**
     * Returns the value of the '<em><b>Rdbms Tables</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsTable}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rdbms Tables</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rdbms Tables</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_RdbmsTables()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsTable> getRdbmsTables();

    /**
     * Returns the value of the '<em><b>Rdbms Views</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsView}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rdbms Views</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rdbms Views</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_RdbmsViews()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsView> getRdbmsViews();

    /**
     * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration</em>' containment reference.
     * @see #setConfiguration(RdbmsConfiguration)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_Configuration()
     * @model containment="true" required="true"
     * @generated
     */
    RdbmsConfiguration getConfiguration();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getConfiguration <em>Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration</em>' containment reference.
     * @see #getConfiguration()
     * @generated
     */
    void setConfiguration(RdbmsConfiguration value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_Version()
     * @model
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Table Operations</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table Operations</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_TableOperations()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsTableOperation> getTableOperations();

    /**
     * Returns the value of the '<em><b>View Records</b></em>' containment reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View Records</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View Records</em>' containment reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsModel_ViewRecords()
     * @model containment="true"
     * @generated
     */
    EList<RdbmsViewRecord> getViewRecords();

} // RdbmsModel
