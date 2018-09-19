/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getName <em>Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getRdbmsTypeName <em>Rdbms Type Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getUuid <em>Uuid</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getDescription <em>Description</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getSize <em>Size</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getPrecision <em>Precision</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getScale <em>Scale</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getStorageByte <em>Storage Byte</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType()
 * @model
 * @generated
 */
public interface RdbmsFieldType extends EObject {
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rdbms Type Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rdbms Type Name</em>' attribute.
     * @see #setRdbmsTypeName(String)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_RdbmsTypeName()
     * @model
     * @generated
     */
    String getRdbmsTypeName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getRdbmsTypeName <em>Rdbms Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rdbms Type Name</em>' attribute.
     * @see #getRdbmsTypeName()
     * @generated
     */
    void setRdbmsTypeName(String value);

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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Uuid()
     * @model
     * @generated
     */
    String getUuid();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getUuid <em>Uuid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uuid</em>' attribute.
     * @see #getUuid()
     * @generated
     */
    void setUuid(String value);

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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size</em>' attribute.
     * @see #setSize(int)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Size()
     * @model
     * @generated
     */
    int getSize();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getSize <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Size</em>' attribute.
     * @see #getSize()
     * @generated
     */
    void setSize(int value);

    /**
     * Returns the value of the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Precision</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Precision</em>' attribute.
     * @see #setPrecision(int)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Precision()
     * @model
     * @generated
     */
    int getPrecision();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getPrecision <em>Precision</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Precision</em>' attribute.
     * @see #getPrecision()
     * @generated
     */
    void setPrecision(int value);

    /**
     * Returns the value of the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scale</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scale</em>' attribute.
     * @see #setScale(int)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_Scale()
     * @model
     * @generated
     */
    int getScale();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getScale <em>Scale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scale</em>' attribute.
     * @see #getScale()
     * @generated
     */
    void setScale(int value);

    /**
     * Returns the value of the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Storage Byte</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Storage Byte</em>' attribute.
     * @see #setStorageByte(int)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsFieldType_StorageByte()
     * @model
     * @generated
     */
    int getStorageByte();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getStorageByte <em>Storage Byte</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Storage Byte</em>' attribute.
     * @see #getStorageByte()
     * @generated
     */
    void setStorageByte(int value);

} // RdbmsFieldType
