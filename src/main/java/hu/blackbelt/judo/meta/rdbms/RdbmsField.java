/**
 */
package hu.blackbelt.judo.meta.rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable <em>Table</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getType <em>Type</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getRdbmsTypeName <em>Rdbms Type Name</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getSize <em>Size</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getPrecision <em>Precision</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getScale <em>Scale</em>}</li>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getStorageByte <em>Storage Byte</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField()
 * @model abstract="true"
 * @generated
 */
public interface RdbmsField extends RdbmsElement {
    /**
     * Returns the value of the '<em><b>Table</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table</em>' container reference.
     * @see #setTable(RdbmsTable)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Table()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getFields
     * @model opposite="fields" required="true" transient="false"
     * @generated
     */
    RdbmsTable getTable();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable <em>Table</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table</em>' container reference.
     * @see #getTable()
     * @generated
     */
    void setTable(RdbmsTable value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(RdbmsFieldType)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Type()
     * @model
     * @generated
     */
    RdbmsFieldType getType();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(RdbmsFieldType value);

    /**
     * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory</em>' attribute.
     * @see #setMandatory(boolean)
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Mandatory()
     * @model required="true"
     * @generated
     */
    boolean isMandatory();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#isMandatory <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory</em>' attribute.
     * @see #isMandatory()
     * @generated
     */
    void setMandatory(boolean value);

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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_RdbmsTypeName()
     * @model
     * @generated
     */
    String getRdbmsTypeName();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getRdbmsTypeName <em>Rdbms Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rdbms Type Name</em>' attribute.
     * @see #getRdbmsTypeName()
     * @generated
     */
    void setRdbmsTypeName(String value);

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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Size()
     * @model
     * @generated
     */
    int getSize();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getSize <em>Size</em>}' attribute.
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Precision()
     * @model
     * @generated
     */
    int getPrecision();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getPrecision <em>Precision</em>}' attribute.
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_Scale()
     * @model
     * @generated
     */
    int getScale();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getScale <em>Scale</em>}' attribute.
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
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsField_StorageByte()
     * @model
     * @generated
     */
    int getStorageByte();

    /**
     * Sets the value of the '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getStorageByte <em>Storage Byte</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Storage Byte</em>' attribute.
     * @see #getStorageByte()
     * @generated
     */
    void setStorageByte(int value);

} // RdbmsField
