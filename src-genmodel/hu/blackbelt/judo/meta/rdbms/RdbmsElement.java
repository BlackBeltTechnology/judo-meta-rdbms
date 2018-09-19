/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getUuid <em>Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getShortName <em>Short Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getFullName <em>Full Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getDescription <em>Description</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getSqlName <em>Sql Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalName <em>Original Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalPackage <em>Original Package</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsElement extends EObject {
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uuid</em>' attribute.
     * @see #setUuid(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_Uuid()
     * @model unique="false" required="true"
     * @generated
     */
    String getUuid();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getUuid <em>Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uuid</em>' attribute.
     * @see #getUuid()
     * @generated
     */
    void setUuid(String value);

    /**
     * Returns the value of the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Short Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Short Name</em>' attribute.
     * @see #setShortName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_ShortName()
     * @model
     * @generated
     */
    String getShortName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getShortName <em>Short Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Short Name</em>' attribute.
     * @see #getShortName()
     * @generated
     */
    void setShortName(String value);

    /**
     * Returns the value of the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Full Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Full Name</em>' attribute.
     * @see #setFullName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_FullName()
     * @model
     * @generated
     */
    String getFullName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getFullName <em>Full Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Full Name</em>' attribute.
     * @see #getFullName()
     * @generated
     */
    void setFullName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sql Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sql Name</em>' attribute.
     * @see #setSqlName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_SqlName()
     * @model
     * @generated
     */
    String getSqlName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getSqlName <em>Sql Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql Name</em>' attribute.
     * @see #getSqlName()
     * @generated
     */
    void setSqlName(String value);

    /**
     * Returns the value of the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Original Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Original Name</em>' attribute.
     * @see #setOriginalName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_OriginalName()
     * @model
     * @generated
     */
    String getOriginalName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalName <em>Original Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Original Name</em>' attribute.
     * @see #getOriginalName()
     * @generated
     */
    void setOriginalName(String value);

    /**
     * Returns the value of the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Original Package</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Original Package</em>' attribute.
     * @see #setOriginalPackage(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsElement_OriginalPackage()
     * @model
     * @generated
     */
    String getOriginalPackage();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalPackage <em>Original Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Original Package</em>' attribute.
     * @see #getOriginalPackage()
     * @generated
     */
    void setOriginalPackage(String value);

} // RdbmsElement
