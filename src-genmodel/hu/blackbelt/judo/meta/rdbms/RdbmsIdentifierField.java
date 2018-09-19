/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField#getForeignKeys <em>Foreign Keys</em>}</li>
 * </ul>
 *
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIdentifierField()
 * @model
 * @generated
 */
public interface RdbmsIdentifierField extends RdbmsField {
    /**
     * Returns the value of the '<em><b>Foreign Keys</b></em>' reference list.
     * The list contents are of type {@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey}.
     * It is bidirectional and its opposite is '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey <em>Reference Key</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Keys</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreign Keys</em>' reference list.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage#getRdbmsIdentifierField_ForeignKeys()
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey
     * @model opposite="referenceKey"
     * @generated
     */
    EList<RdbmsForeignKey> getForeignKeys();

} // RdbmsIdentifierField
