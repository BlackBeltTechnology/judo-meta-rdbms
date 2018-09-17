/**
 */
package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsFactory
 * @model kind="package"
 * @generated
 */
public interface RdbmsPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "rdbms";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://blackbelt.hu/judo/meta/psm/rdbms";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "rdbms";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RdbmsPackage eINSTANCE = hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl.init();

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsElement()
     * @generated
     */
    int RDBMS_ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__NAME = 0;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__UUID = 1;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__SHORT_NAME = 2;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__FULL_NAME = 3;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__DESCRIPTION = 4;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__SQL_NAME = 5;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__ORIGINAL_NAME = 6;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT__ORIGINAL_PACKAGE = 7;

    /**
     * The number of structural features of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT_FEATURE_COUNT = 8;

    /**
     * The number of operations of the '<em>Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_ELEMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl <em>Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTable()
     * @generated
     */
    int RDBMS_TABLE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Fields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__FIELDS = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Unique Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__UNIQUE_CONSTRAINTS = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Primary Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__PRIMARY_KEY = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__INDEXES = RDBMS_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE__PARENT = RDBMS_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Table</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Table</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsField()
     * @generated
     */
    int RDBMS_FIELD = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__TYPE = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__MANDATORY = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__RDBMS_TYPE_NAME = RDBMS_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__SIZE = RDBMS_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__PRECISION = RDBMS_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__SCALE = RDBMS_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD__STORAGE_BYTE = RDBMS_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The number of operations of the '<em>Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIdentifierFieldImpl <em>Identifier Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsIdentifierFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsIdentifierField()
     * @generated
     */
    int RDBMS_IDENTIFIER_FIELD = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__NAME = RDBMS_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__UUID = RDBMS_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__SHORT_NAME = RDBMS_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__FULL_NAME = RDBMS_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__DESCRIPTION = RDBMS_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__SQL_NAME = RDBMS_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__ORIGINAL_NAME = RDBMS_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__ORIGINAL_PACKAGE = RDBMS_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__TABLE = RDBMS_FIELD__TABLE;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__TYPE = RDBMS_FIELD__TYPE;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__MANDATORY = RDBMS_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__RDBMS_TYPE_NAME = RDBMS_FIELD__RDBMS_TYPE_NAME;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__SIZE = RDBMS_FIELD__SIZE;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__PRECISION = RDBMS_FIELD__PRECISION;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__SCALE = RDBMS_FIELD__SCALE;

    /**
     * The feature id for the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__STORAGE_BYTE = RDBMS_FIELD__STORAGE_BYTE;

    /**
     * The feature id for the '<em><b>Foreign Keys</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD__FOREIGN_KEYS = RDBMS_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT = RDBMS_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_IDENTIFIER_FIELD_OPERATION_COUNT = RDBMS_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl <em>Foreign Key</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsForeignKey()
     * @generated
     */
    int RDBMS_FOREIGN_KEY = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__NAME = RDBMS_IDENTIFIER_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__UUID = RDBMS_IDENTIFIER_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__SHORT_NAME = RDBMS_IDENTIFIER_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__FULL_NAME = RDBMS_IDENTIFIER_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__DESCRIPTION = RDBMS_IDENTIFIER_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__SQL_NAME = RDBMS_IDENTIFIER_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__ORIGINAL_NAME = RDBMS_IDENTIFIER_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__ORIGINAL_PACKAGE = RDBMS_IDENTIFIER_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__TABLE = RDBMS_IDENTIFIER_FIELD__TABLE;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__TYPE = RDBMS_IDENTIFIER_FIELD__TYPE;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__MANDATORY = RDBMS_IDENTIFIER_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__RDBMS_TYPE_NAME = RDBMS_IDENTIFIER_FIELD__RDBMS_TYPE_NAME;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__SIZE = RDBMS_IDENTIFIER_FIELD__SIZE;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__PRECISION = RDBMS_IDENTIFIER_FIELD__PRECISION;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__SCALE = RDBMS_IDENTIFIER_FIELD__SCALE;

    /**
     * The feature id for the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__STORAGE_BYTE = RDBMS_IDENTIFIER_FIELD__STORAGE_BYTE;

    /**
     * The feature id for the '<em><b>Foreign Keys</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__FOREIGN_KEYS = RDBMS_IDENTIFIER_FIELD__FOREIGN_KEYS;

    /**
     * The feature id for the '<em><b>Reference Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__REFERENCE_KEY = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Inheritence Based</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__INHERITENCE_BASED = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Foreign Key Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Delete On Cascade</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Deferred</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__DEFERRED = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY__READ_ONLY = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Foreign Key</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY_FEATURE_COUNT = RDBMS_IDENTIFIER_FIELD_FEATURE_COUNT + 6;

    /**
     * The number of operations of the '<em>Foreign Key</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FOREIGN_KEY_OPERATION_COUNT = RDBMS_IDENTIFIER_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl <em>Unique Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsUniqueConstraint()
     * @generated
     */
    int RDBMS_UNIQUE_CONSTRAINT = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Fields</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT__FIELDS = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Unique Constraint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Unique Constraint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_UNIQUE_CONSTRAINT_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl <em>Junction Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsJunctionTable()
     * @generated
     */
    int RDBMS_JUNCTION_TABLE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__NAME = RDBMS_TABLE__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__UUID = RDBMS_TABLE__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__SHORT_NAME = RDBMS_TABLE__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__FULL_NAME = RDBMS_TABLE__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__DESCRIPTION = RDBMS_TABLE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__SQL_NAME = RDBMS_TABLE__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__ORIGINAL_NAME = RDBMS_TABLE__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__ORIGINAL_PACKAGE = RDBMS_TABLE__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Fields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__FIELDS = RDBMS_TABLE__FIELDS;

    /**
     * The feature id for the '<em><b>Unique Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__UNIQUE_CONSTRAINTS = RDBMS_TABLE__UNIQUE_CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Primary Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__PRIMARY_KEY = RDBMS_TABLE__PRIMARY_KEY;

    /**
     * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__INDEXES = RDBMS_TABLE__INDEXES;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__PARENT = RDBMS_TABLE__PARENT;

    /**
     * The feature id for the '<em><b>Field1</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__FIELD1 = RDBMS_TABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Field2</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE__FIELD2 = RDBMS_TABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Junction Table</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE_FEATURE_COUNT = RDBMS_TABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Junction Table</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_JUNCTION_TABLE_OPERATION_COUNT = RDBMS_TABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsView()
     * @generated
     */
    int RDBMS_VIEW = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Fields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__FIELDS = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Primary Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__PRIMARY_TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Origin Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__ORIGIN_UUID = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Relations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__RELATIONS = RDBMS_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Primary Identifier Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD = RDBMS_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Tables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW__TABLES = RDBMS_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The number of operations of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl <em>View Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewField()
     * @generated
     */
    int RDBMS_VIEW_FIELD = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__VIEW = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD__INHERITED = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>View Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>View Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FIELD_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl <em>View Table Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewTableField()
     * @generated
     */
    int RDBMS_VIEW_TABLE_FIELD = 28;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__NAME = RDBMS_VIEW_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__UUID = RDBMS_VIEW_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__SHORT_NAME = RDBMS_VIEW_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__FULL_NAME = RDBMS_VIEW_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__DESCRIPTION = RDBMS_VIEW_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__SQL_NAME = RDBMS_VIEW_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__ORIGINAL_NAME = RDBMS_VIEW_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__VIEW = RDBMS_VIEW_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__INHERITED = RDBMS_VIEW_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD = RDBMS_VIEW_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Foreign</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD__FOREIGN = RDBMS_VIEW_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>View Table Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD_FEATURE_COUNT = RDBMS_VIEW_FIELD_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>View Table Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_TABLE_FIELD_OPERATION_COUNT = RDBMS_VIEW_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewAliasFieldImpl <em>View Alias Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewAliasFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewAliasField()
     * @generated
     */
    int RDBMS_VIEW_ALIAS_FIELD = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__NAME = RDBMS_VIEW_TABLE_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__UUID = RDBMS_VIEW_TABLE_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__SHORT_NAME = RDBMS_VIEW_TABLE_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__FULL_NAME = RDBMS_VIEW_TABLE_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__DESCRIPTION = RDBMS_VIEW_TABLE_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__SQL_NAME = RDBMS_VIEW_TABLE_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_NAME = RDBMS_VIEW_TABLE_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_TABLE_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__VIEW = RDBMS_VIEW_TABLE_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__INHERITED = RDBMS_VIEW_TABLE_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__TABLE_FIELD = RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD;

    /**
     * The feature id for the '<em><b>Foreign</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__FOREIGN = RDBMS_VIEW_TABLE_FIELD__FOREIGN;

    /**
     * The feature id for the '<em><b>Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD__ALIAS = RDBMS_VIEW_TABLE_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>View Alias Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD_FEATURE_COUNT = RDBMS_VIEW_TABLE_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>View Alias Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_ALIAS_FIELD_OPERATION_COUNT = RDBMS_VIEW_TABLE_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewValueFieldImpl <em>View Value Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewValueFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewValueField()
     * @generated
     */
    int RDBMS_VIEW_VALUE_FIELD = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__NAME = RDBMS_VIEW_ALIAS_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__UUID = RDBMS_VIEW_ALIAS_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__SHORT_NAME = RDBMS_VIEW_ALIAS_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__FULL_NAME = RDBMS_VIEW_ALIAS_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__DESCRIPTION = RDBMS_VIEW_ALIAS_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__SQL_NAME = RDBMS_VIEW_ALIAS_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__ORIGINAL_NAME = RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__VIEW = RDBMS_VIEW_ALIAS_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__INHERITED = RDBMS_VIEW_ALIAS_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__TABLE_FIELD = RDBMS_VIEW_ALIAS_FIELD__TABLE_FIELD;

    /**
     * The feature id for the '<em><b>Foreign</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__FOREIGN = RDBMS_VIEW_ALIAS_FIELD__FOREIGN;

    /**
     * The feature id for the '<em><b>Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD__ALIAS = RDBMS_VIEW_ALIAS_FIELD__ALIAS;

    /**
     * The number of structural features of the '<em>View Value Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD_FEATURE_COUNT = RDBMS_VIEW_ALIAS_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>View Value Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_VALUE_FIELD_OPERATION_COUNT = RDBMS_VIEW_ALIAS_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl <em>View Expression Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewExpressionField()
     * @generated
     */
    int RDBMS_VIEW_EXPRESSION_FIELD = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__NAME = RDBMS_VIEW_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__UUID = RDBMS_VIEW_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__SHORT_NAME = RDBMS_VIEW_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__FULL_NAME = RDBMS_VIEW_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__DESCRIPTION = RDBMS_VIEW_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__SQL_NAME = RDBMS_VIEW_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__ORIGINAL_NAME = RDBMS_VIEW_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__VIEW = RDBMS_VIEW_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__INHERITED = RDBMS_VIEW_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS = RDBMS_VIEW_FIELD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION = RDBMS_VIEW_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>View Expression Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD_FEATURE_COUNT = RDBMS_VIEW_FIELD_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>View Expression Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_EXPRESSION_FIELD_OPERATION_COUNT = RDBMS_VIEW_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsExpressionImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsExpression()
     * @generated
     */
    int RDBMS_EXPRESSION = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION__EXPRESSION = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_EXPRESSION_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFieldType()
     * @generated
     */
    int RDBMS_FIELD_TYPE = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME = 1;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__UUID = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__SIZE = 4;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__PRECISION = 5;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__SCALE = 6;

    /**
     * The feature id for the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE__STORAGE_BYTE = 7;

    /**
     * The number of structural features of the '<em>Field Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE_FEATURE_COUNT = 8;

    /**
     * The number of operations of the '<em>Field Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModel()
     * @generated
     */
    int RDBMS_MODEL = 13;

    /**
     * The feature id for the '<em><b>Rdbms Field Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__RDBMS_FIELD_TYPES = 0;

    /**
     * The feature id for the '<em><b>Rdbms Tables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__RDBMS_TABLES = 1;

    /**
     * The feature id for the '<em><b>Rdbms Views</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__RDBMS_VIEWS = 2;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__CONFIGURATION = 3;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__VERSION = 4;

    /**
     * The feature id for the '<em><b>Table Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__TABLE_OPERATIONS = 5;

    /**
     * The feature id for the '<em><b>View Records</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL__VIEW_RECORDS = 6;

    /**
     * The number of structural features of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODEL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsValueFieldImpl <em>Value Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsValueFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsValueField()
     * @generated
     */
    int RDBMS_VALUE_FIELD = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__NAME = RDBMS_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__UUID = RDBMS_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__SHORT_NAME = RDBMS_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__FULL_NAME = RDBMS_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__DESCRIPTION = RDBMS_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__SQL_NAME = RDBMS_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__ORIGINAL_NAME = RDBMS_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__ORIGINAL_PACKAGE = RDBMS_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__TABLE = RDBMS_FIELD__TABLE;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__TYPE = RDBMS_FIELD__TYPE;

    /**
     * The feature id for the '<em><b>Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__MANDATORY = RDBMS_FIELD__MANDATORY;

    /**
     * The feature id for the '<em><b>Rdbms Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__RDBMS_TYPE_NAME = RDBMS_FIELD__RDBMS_TYPE_NAME;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__SIZE = RDBMS_FIELD__SIZE;

    /**
     * The feature id for the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__PRECISION = RDBMS_FIELD__PRECISION;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__SCALE = RDBMS_FIELD__SCALE;

    /**
     * The feature id for the '<em><b>Storage Byte</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__STORAGE_BYTE = RDBMS_FIELD__STORAGE_BYTE;

    /**
     * The feature id for the '<em><b>Technical</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD__TECHNICAL = RDBMS_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Value Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD_FEATURE_COUNT = RDBMS_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Value Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VALUE_FIELD_OPERATION_COUNT = RDBMS_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewIdentifierFieldImpl <em>View Identifier Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewIdentifierFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewIdentifierField()
     * @generated
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD = 15;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__NAME = RDBMS_VIEW_ALIAS_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__UUID = RDBMS_VIEW_ALIAS_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__SHORT_NAME = RDBMS_VIEW_ALIAS_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__FULL_NAME = RDBMS_VIEW_ALIAS_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__DESCRIPTION = RDBMS_VIEW_ALIAS_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__SQL_NAME = RDBMS_VIEW_ALIAS_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__ORIGINAL_NAME = RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_ALIAS_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__VIEW = RDBMS_VIEW_ALIAS_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__INHERITED = RDBMS_VIEW_ALIAS_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__TABLE_FIELD = RDBMS_VIEW_ALIAS_FIELD__TABLE_FIELD;

    /**
     * The feature id for the '<em><b>Foreign</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__FOREIGN = RDBMS_VIEW_ALIAS_FIELD__FOREIGN;

    /**
     * The feature id for the '<em><b>Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD__ALIAS = RDBMS_VIEW_ALIAS_FIELD__ALIAS;

    /**
     * The number of structural features of the '<em>View Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD_FEATURE_COUNT = RDBMS_VIEW_ALIAS_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>View Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_IDENTIFIER_FIELD_OPERATION_COUNT = RDBMS_VIEW_ALIAS_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsConfiguration()
     * @generated
     */
    int RDBMS_CONFIGURATION = 16;

    /**
     * The feature id for the '<em><b>Dialect</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CONFIGURATION__DIALECT = 0;

    /**
     * The feature id for the '<em><b>Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CONFIGURATION__FEATURES = 1;

    /**
     * The number of structural features of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CONFIGURATION_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CONFIGURATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFeatureImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFeature()
     * @generated
     */
    int RDBMS_FEATURE = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FEATURE__NAME = 0;

    /**
     * The number of structural features of the '<em>Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FEATURE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FEATURE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl <em>Table Alias</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTableAlias()
     * @generated
     */
    int RDBMS_TABLE_ALIAS = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS__VIEW = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Table Alias</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Table Alias</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_ALIAS_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsLabelExpressionImpl <em>Label Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsLabelExpressionImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsLabelExpression()
     * @generated
     */
    int RDBMS_LABEL_EXPRESSION = 19;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__NAME = RDBMS_EXPRESSION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__UUID = RDBMS_EXPRESSION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__SHORT_NAME = RDBMS_EXPRESSION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__FULL_NAME = RDBMS_EXPRESSION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__DESCRIPTION = RDBMS_EXPRESSION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__SQL_NAME = RDBMS_EXPRESSION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__ORIGINAL_NAME = RDBMS_EXPRESSION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__ORIGINAL_PACKAGE = RDBMS_EXPRESSION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__EXPRESSION = RDBMS_EXPRESSION__EXPRESSION;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION__TEXT = RDBMS_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Label Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION_FEATURE_COUNT = RDBMS_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Label Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_LABEL_EXPRESSION_OPERATION_COUNT = RDBMS_EXPRESSION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsRelationExpressionImpl <em>Relation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsRelationExpressionImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsRelationExpression()
     * @generated
     */
    int RDBMS_RELATION_EXPRESSION = 20;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__NAME = RDBMS_EXPRESSION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__UUID = RDBMS_EXPRESSION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__SHORT_NAME = RDBMS_EXPRESSION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__FULL_NAME = RDBMS_EXPRESSION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__DESCRIPTION = RDBMS_EXPRESSION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__SQL_NAME = RDBMS_EXPRESSION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__ORIGINAL_NAME = RDBMS_EXPRESSION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__ORIGINAL_PACKAGE = RDBMS_EXPRESSION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__EXPRESSION = RDBMS_EXPRESSION__EXPRESSION;

    /**
     * The feature id for the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION__FIELD = RDBMS_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Relation Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION_FEATURE_COUNT = RDBMS_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Relation Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_RELATION_EXPRESSION_OPERATION_COUNT = RDBMS_EXPRESSION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableOperationImpl <em>Table Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTableOperation()
     * @generated
     */
    int RDBMS_TABLE_OPERATION = 33;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION__TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_TABLE_OPERATION_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl <em>Modify Table Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModifyTableOperation()
     * @generated
     */
    int RDBMS_MODIFY_TABLE_OPERATION = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__NAME = RDBMS_TABLE_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__UUID = RDBMS_TABLE_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__SHORT_NAME = RDBMS_TABLE_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__FULL_NAME = RDBMS_TABLE_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__DESCRIPTION = RDBMS_TABLE_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__SQL_NAME = RDBMS_TABLE_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__ORIGINAL_NAME = RDBMS_TABLE_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__ORIGINAL_PACKAGE = RDBMS_TABLE_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__TABLE = RDBMS_TABLE_OPERATION__TABLE;

    /**
     * The feature id for the '<em><b>Create Field Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Modify Field Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Delete Field Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Previous Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Name Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Modify Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION_FEATURE_COUNT = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Modify Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_TABLE_OPERATION_OPERATION_COUNT = RDBMS_TABLE_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl <em>Field Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFieldOperation()
     * @generated
     */
    int RDBMS_FIELD_OPERATION = 23;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__FIELD = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Review Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION__REVIEW_REQUIRED = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_FIELD_OPERATION_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateFieldOperationImpl <em>Create Field Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateFieldOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsCreateFieldOperation()
     * @generated
     */
    int RDBMS_CREATE_FIELD_OPERATION = 24;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__NAME = RDBMS_FIELD_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__UUID = RDBMS_FIELD_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__SHORT_NAME = RDBMS_FIELD_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__FULL_NAME = RDBMS_FIELD_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__DESCRIPTION = RDBMS_FIELD_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__SQL_NAME = RDBMS_FIELD_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__ORIGINAL_NAME = RDBMS_FIELD_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__ORIGINAL_PACKAGE = RDBMS_FIELD_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__FIELD = RDBMS_FIELD_OPERATION__FIELD;

    /**
     * The feature id for the '<em><b>Review Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION__REVIEW_REQUIRED = RDBMS_FIELD_OPERATION__REVIEW_REQUIRED;

    /**
     * The number of structural features of the '<em>Create Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION_FEATURE_COUNT = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Create Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_FIELD_OPERATION_OPERATION_COUNT = RDBMS_FIELD_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl <em>Modify Field Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModifyFieldOperation()
     * @generated
     */
    int RDBMS_MODIFY_FIELD_OPERATION = 25;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__NAME = RDBMS_FIELD_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__UUID = RDBMS_FIELD_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__SHORT_NAME = RDBMS_FIELD_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__FULL_NAME = RDBMS_FIELD_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__DESCRIPTION = RDBMS_FIELD_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__SQL_NAME = RDBMS_FIELD_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__ORIGINAL_NAME = RDBMS_FIELD_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__ORIGINAL_PACKAGE = RDBMS_FIELD_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__FIELD = RDBMS_FIELD_OPERATION__FIELD;

    /**
     * The feature id for the '<em><b>Review Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__REVIEW_REQUIRED = RDBMS_FIELD_OPERATION__REVIEW_REQUIRED;

    /**
     * The feature id for the '<em><b>Type Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Mandatory Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Previous Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Size Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Name Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Changed Value Field To Foreign Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Changed Foreign Key To Value Field</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Modify Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION_FEATURE_COUNT = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>Modify Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_MODIFY_FIELD_OPERATION_OPERATION_COUNT = RDBMS_FIELD_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteFieldOperationImpl <em>Delete Field Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteFieldOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsDeleteFieldOperation()
     * @generated
     */
    int RDBMS_DELETE_FIELD_OPERATION = 26;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__NAME = RDBMS_FIELD_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__UUID = RDBMS_FIELD_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__SHORT_NAME = RDBMS_FIELD_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__FULL_NAME = RDBMS_FIELD_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__DESCRIPTION = RDBMS_FIELD_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__SQL_NAME = RDBMS_FIELD_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__ORIGINAL_NAME = RDBMS_FIELD_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__ORIGINAL_PACKAGE = RDBMS_FIELD_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__FIELD = RDBMS_FIELD_OPERATION__FIELD;

    /**
     * The feature id for the '<em><b>Review Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION__REVIEW_REQUIRED = RDBMS_FIELD_OPERATION__REVIEW_REQUIRED;

    /**
     * The number of structural features of the '<em>Delete Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION_FEATURE_COUNT = RDBMS_FIELD_OPERATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Delete Field Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_FIELD_OPERATION_OPERATION_COUNT = RDBMS_FIELD_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl <em>View Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRelation()
     * @generated
     */
    int RDBMS_VIEW_RELATION = 27;

    /**
     * The feature id for the '<em><b>From Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION__FROM_ALIAS = 0;

    /**
     * The feature id for the '<em><b>To Alias</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION__TO_ALIAS = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION__NAME = 2;

    /**
     * The feature id for the '<em><b>From Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION__FROM_FIELD = 3;

    /**
     * The feature id for the '<em><b>To Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION__TO_FIELD = 4;

    /**
     * The number of structural features of the '<em>View Relation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>View Relation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RELATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewForeignIdentifierFieldImpl <em>View Foreign Identifier Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewForeignIdentifierFieldImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewForeignIdentifierField()
     * @generated
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD = 29;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__NAME = RDBMS_VIEW_TABLE_FIELD__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__UUID = RDBMS_VIEW_TABLE_FIELD__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__SHORT_NAME = RDBMS_VIEW_TABLE_FIELD__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__FULL_NAME = RDBMS_VIEW_TABLE_FIELD__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__DESCRIPTION = RDBMS_VIEW_TABLE_FIELD__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__SQL_NAME = RDBMS_VIEW_TABLE_FIELD__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__ORIGINAL_NAME = RDBMS_VIEW_TABLE_FIELD__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__ORIGINAL_PACKAGE = RDBMS_VIEW_TABLE_FIELD__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>View</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__VIEW = RDBMS_VIEW_TABLE_FIELD__VIEW;

    /**
     * The feature id for the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__INHERITED = RDBMS_VIEW_TABLE_FIELD__INHERITED;

    /**
     * The feature id for the '<em><b>Table Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__TABLE_FIELD = RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD;

    /**
     * The feature id for the '<em><b>Foreign</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__FOREIGN = RDBMS_VIEW_TABLE_FIELD__FOREIGN;

    /**
     * The feature id for the '<em><b>Reference Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER = RDBMS_VIEW_TABLE_FIELD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>View Foreign Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD_FEATURE_COUNT = RDBMS_VIEW_TABLE_FIELD_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>View Foreign Identifier Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD_OPERATION_COUNT = RDBMS_VIEW_TABLE_FIELD_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl <em>Index</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsIndex()
     * @generated
     */
    int RDBMS_INDEX = 30;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__NAME = RDBMS_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__UUID = RDBMS_ELEMENT__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__SHORT_NAME = RDBMS_ELEMENT__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__FULL_NAME = RDBMS_ELEMENT__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__DESCRIPTION = RDBMS_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__SQL_NAME = RDBMS_ELEMENT__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__ORIGINAL_NAME = RDBMS_ELEMENT__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__ORIGINAL_PACKAGE = RDBMS_ELEMENT__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__TABLE = RDBMS_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Fields</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__FIELDS = RDBMS_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX__UNIQUE = RDBMS_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Index</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX_FEATURE_COUNT = RDBMS_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Index</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_INDEX_OPERATION_COUNT = RDBMS_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl <em>View Record</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRecord()
     * @generated
     */
    int RDBMS_VIEW_RECORD = 31;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD__VALUES = 0;

    /**
     * The feature id for the '<em><b>View</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD__VIEW = 1;

    /**
     * The number of structural features of the '<em>View Record</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>View Record</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl <em>View Record Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRecordValue()
     * @generated
     */
    int RDBMS_VIEW_RECORD_VALUE = 32;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_VALUE__VALUE = 0;

    /**
     * The feature id for the '<em><b>Identifier Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD = 1;

    /**
     * The feature id for the '<em><b>Value Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD = 2;

    /**
     * The number of structural features of the '<em>View Record Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_VALUE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>View Record Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_VIEW_RECORD_VALUE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateTableOperationImpl <em>Create Table Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateTableOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsCreateTableOperation()
     * @generated
     */
    int RDBMS_CREATE_TABLE_OPERATION = 34;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__NAME = RDBMS_TABLE_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__UUID = RDBMS_TABLE_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__SHORT_NAME = RDBMS_TABLE_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__FULL_NAME = RDBMS_TABLE_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__DESCRIPTION = RDBMS_TABLE_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__SQL_NAME = RDBMS_TABLE_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__ORIGINAL_NAME = RDBMS_TABLE_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__ORIGINAL_PACKAGE = RDBMS_TABLE_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION__TABLE = RDBMS_TABLE_OPERATION__TABLE;

    /**
     * The number of structural features of the '<em>Create Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION_FEATURE_COUNT = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Create Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_CREATE_TABLE_OPERATION_OPERATION_COUNT = RDBMS_TABLE_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteTableOperationImpl <em>Delete Table Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteTableOperationImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsDeleteTableOperation()
     * @generated
     */
    int RDBMS_DELETE_TABLE_OPERATION = 35;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__NAME = RDBMS_TABLE_OPERATION__NAME;

    /**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__UUID = RDBMS_TABLE_OPERATION__UUID;

    /**
     * The feature id for the '<em><b>Short Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__SHORT_NAME = RDBMS_TABLE_OPERATION__SHORT_NAME;

    /**
     * The feature id for the '<em><b>Full Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__FULL_NAME = RDBMS_TABLE_OPERATION__FULL_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__DESCRIPTION = RDBMS_TABLE_OPERATION__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Sql Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__SQL_NAME = RDBMS_TABLE_OPERATION__SQL_NAME;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__ORIGINAL_NAME = RDBMS_TABLE_OPERATION__ORIGINAL_NAME;

    /**
     * The feature id for the '<em><b>Original Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__ORIGINAL_PACKAGE = RDBMS_TABLE_OPERATION__ORIGINAL_PACKAGE;

    /**
     * The feature id for the '<em><b>Table</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION__TABLE = RDBMS_TABLE_OPERATION__TABLE;

    /**
     * The number of structural features of the '<em>Delete Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION_FEATURE_COUNT = RDBMS_TABLE_OPERATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Delete Table Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_DELETE_TABLE_OPERATION_OPERATION_COUNT = RDBMS_TABLE_OPERATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl <em>Operation Meta</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl
     * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsOperationMeta()
     * @generated
     */
    int RDBMS_OPERATION_META = 36;

    /**
     * The feature id for the '<em><b>Previous Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_OPERATION_META__PREVIOUS_MODEL = 0;

    /**
     * The feature id for the '<em><b>Current Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_OPERATION_META__CURRENT_MODEL = 1;

    /**
     * The number of structural features of the '<em>Operation Meta</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_OPERATION_META_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Operation Meta</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RDBMS_OPERATION_META_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement
     * @generated
     */
    EClass getRdbmsElement();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getName()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_Name();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getUuid <em>Uuid</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uuid</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getUuid()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_Uuid();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getShortName <em>Short Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Short Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getShortName()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_ShortName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getFullName <em>Full Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Full Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getFullName()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_FullName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getDescription()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_Description();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getSqlName <em>Sql Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getSqlName()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_SqlName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalName <em>Original Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Original Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalName()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_OriginalName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalPackage <em>Original Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Original Package</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement#getOriginalPackage()
     * @see #getRdbmsElement()
     * @generated
     */
    EAttribute getRdbmsElement_OriginalPackage();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable
     * @generated
     */
    EClass getRdbmsTable();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Fields</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getFields()
     * @see #getRdbmsTable()
     * @generated
     */
    EReference getRdbmsTable_Fields();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getUniqueConstraints <em>Unique Constraints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Unique Constraints</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getUniqueConstraints()
     * @see #getRdbmsTable()
     * @generated
     */
    EReference getRdbmsTable_UniqueConstraints();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getPrimaryKey <em>Primary Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Primary Key</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getPrimaryKey()
     * @see #getRdbmsTable()
     * @generated
     */
    EReference getRdbmsTable_PrimaryKey();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getIndexes <em>Indexes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Indexes</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getIndexes()
     * @see #getRdbmsTable()
     * @generated
     */
    EReference getRdbmsTable_Indexes();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable#getParent()
     * @see #getRdbmsTable()
     * @generated
     */
    EReference getRdbmsTable_Parent();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField
     * @generated
     */
    EClass getRdbmsField();

    /**
     * Returns the meta object for the container reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getTable()
     * @see #getRdbmsField()
     * @generated
     */
    EReference getRdbmsField_Table();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getType()
     * @see #getRdbmsField()
     * @generated
     */
    EReference getRdbmsField_Type();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#isMandatory <em>Mandatory</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#isMandatory()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_Mandatory();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getRdbmsTypeName <em>Rdbms Type Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rdbms Type Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getRdbmsTypeName()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_RdbmsTypeName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getSize()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_Size();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getPrecision <em>Precision</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Precision</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getPrecision()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_Precision();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getScale <em>Scale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Scale</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getScale()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_Scale();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField#getStorageByte <em>Storage Byte</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Storage Byte</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField#getStorageByte()
     * @see #getRdbmsField()
     * @generated
     */
    EAttribute getRdbmsField_StorageByte();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey <em>Foreign Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Foreign Key</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey
     * @generated
     */
    EClass getRdbmsForeignKey();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey <em>Reference Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference Key</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getReferenceKey()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EReference getRdbmsForeignKey_ReferenceKey();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isInheritenceBased <em>Inheritence Based</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inheritence Based</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isInheritenceBased()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EAttribute getRdbmsForeignKey_InheritenceBased();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getForeignKeySqlName <em>Foreign Key Sql Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Foreign Key Sql Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#getForeignKeySqlName()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EAttribute getRdbmsForeignKey_ForeignKeySqlName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeleteOnCascade <em>Delete On Cascade</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Delete On Cascade</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeleteOnCascade()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EAttribute getRdbmsForeignKey_DeleteOnCascade();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeferred <em>Deferred</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deferred</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isDeferred()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EAttribute getRdbmsForeignKey_Deferred();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isReadOnly <em>Read Only</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Only</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey#isReadOnly()
     * @see #getRdbmsForeignKey()
     * @generated
     */
    EAttribute getRdbmsForeignKey_ReadOnly();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint <em>Unique Constraint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unique Constraint</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint
     * @generated
     */
    EClass getRdbmsUniqueConstraint();

    /**
     * Returns the meta object for the container reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getTable()
     * @see #getRdbmsUniqueConstraint()
     * @generated
     */
    EReference getRdbmsUniqueConstraint_Table();

    /**
     * Returns the meta object for the reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Fields</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint#getFields()
     * @see #getRdbmsUniqueConstraint()
     * @generated
     */
    EReference getRdbmsUniqueConstraint_Fields();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable <em>Junction Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Junction Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable
     * @generated
     */
    EClass getRdbmsJunctionTable();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField1 <em>Field1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Field1</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField1()
     * @see #getRdbmsJunctionTable()
     * @generated
     */
    EReference getRdbmsJunctionTable_Field1();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField2 <em>Field2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Field2</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable#getField2()
     * @see #getRdbmsJunctionTable()
     * @generated
     */
    EReference getRdbmsJunctionTable_Field2();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField <em>Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Identifier Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField
     * @generated
     */
    EClass getRdbmsIdentifierField();

    /**
     * Returns the meta object for the reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField#getForeignKeys <em>Foreign Keys</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Foreign Keys</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField#getForeignKeys()
     * @see #getRdbmsIdentifierField()
     * @generated
     */
    EReference getRdbmsIdentifierField_ForeignKeys();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView
     * @generated
     */
    EClass getRdbmsView();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Fields</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getFields()
     * @see #getRdbmsView()
     * @generated
     */
    EReference getRdbmsView_Fields();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryTable <em>Primary Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Primary Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryTable()
     * @see #getRdbmsView()
     * @generated
     */
    EReference getRdbmsView_PrimaryTable();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getOriginUuid <em>Origin Uuid</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Origin Uuid</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getOriginUuid()
     * @see #getRdbmsView()
     * @generated
     */
    EAttribute getRdbmsView_OriginUuid();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getRelations <em>Relations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Relations</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getRelations()
     * @see #getRdbmsView()
     * @generated
     */
    EReference getRdbmsView_Relations();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryIdentifierField <em>Primary Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Primary Identifier Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getPrimaryIdentifierField()
     * @see #getRdbmsView()
     * @generated
     */
    EReference getRdbmsView_PrimaryIdentifierField();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView#getTables <em>Tables</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tables</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView#getTables()
     * @see #getRdbmsView()
     * @generated
     */
    EReference getRdbmsView_Tables();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField <em>View Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewField
     * @generated
     */
    EClass getRdbmsViewField();

    /**
     * Returns the meta object for the container reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>View</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewField#getView()
     * @see #getRdbmsViewField()
     * @generated
     */
    EReference getRdbmsViewField_View();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField#isInherited <em>Inherited</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inherited</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewField#isInherited()
     * @see #getRdbmsViewField()
     * @generated
     */
    EAttribute getRdbmsViewField_Inherited();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField <em>View Value Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Value Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField
     * @generated
     */
    EClass getRdbmsViewValueField();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField <em>View Expression Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Expression Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField
     * @generated
     */
    EClass getRdbmsViewExpressionField();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expressions</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpressions()
     * @see #getRdbmsViewExpressionField()
     * @generated
     */
    EReference getRdbmsViewExpressionField_Expressions();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expression</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField#getExpression()
     * @see #getRdbmsViewExpressionField()
     * @generated
     */
    EAttribute getRdbmsViewExpressionField_Expression();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsExpression
     * @generated
     */
    EClass getRdbmsExpression();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsExpression#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expression</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsExpression#getExpression()
     * @see #getRdbmsExpression()
     * @generated
     */
    EAttribute getRdbmsExpression_Expression();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType <em>Field Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field Type</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType
     * @generated
     */
    EClass getRdbmsFieldType();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getName()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Name();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getRdbmsTypeName <em>Rdbms Type Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rdbms Type Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getRdbmsTypeName()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_RdbmsTypeName();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getUuid <em>Uuid</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uuid</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getUuid()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Uuid();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getDescription()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Description();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getSize()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Size();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getPrecision <em>Precision</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Precision</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getPrecision()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Precision();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getScale <em>Scale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Scale</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getScale()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_Scale();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getStorageByte <em>Storage Byte</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Storage Byte</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType#getStorageByte()
     * @see #getRdbmsFieldType()
     * @generated
     */
    EAttribute getRdbmsFieldType_StorageByte();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel
     * @generated
     */
    EClass getRdbmsModel();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsFieldTypes <em>Rdbms Field Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Rdbms Field Types</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsFieldTypes()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_RdbmsFieldTypes();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsTables <em>Rdbms Tables</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Rdbms Tables</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsTables()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_RdbmsTables();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsViews <em>Rdbms Views</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Rdbms Views</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getRdbmsViews()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_RdbmsViews();

    /**
     * Returns the meta object for the containment reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Configuration</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getConfiguration()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_Configuration();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getVersion()
     * @see #getRdbmsModel()
     * @generated
     */
    EAttribute getRdbmsModel_Version();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getTableOperations <em>Table Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Table Operations</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getTableOperations()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_TableOperations();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel#getViewRecords <em>View Records</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>View Records</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel#getViewRecords()
     * @see #getRdbmsModel()
     * @generated
     */
    EReference getRdbmsModel_ViewRecords();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsValueField <em>Value Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsValueField
     * @generated
     */
    EClass getRdbmsValueField();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsValueField#isTechnical <em>Technical</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Technical</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsValueField#isTechnical()
     * @see #getRdbmsValueField()
     * @generated
     */
    EAttribute getRdbmsValueField_Technical();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField <em>View Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Identifier Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField
     * @generated
     */
    EClass getRdbmsViewIdentifierField();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration
     * @generated
     */
    EClass getRdbmsConfiguration();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getDialect <em>Dialect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dialect</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getDialect()
     * @see #getRdbmsConfiguration()
     * @generated
     */
    EAttribute getRdbmsConfiguration_Dialect();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getFeatures <em>Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Features</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration#getFeatures()
     * @see #getRdbmsConfiguration()
     * @generated
     */
    EReference getRdbmsConfiguration_Features();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFeature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFeature
     * @generated
     */
    EClass getRdbmsFeature();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFeature#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFeature#getName()
     * @see #getRdbmsFeature()
     * @generated
     */
    EAttribute getRdbmsFeature_Name();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias <em>Table Alias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Table Alias</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias
     * @generated
     */
    EClass getRdbmsTableAlias();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getTable()
     * @see #getRdbmsTableAlias()
     * @generated
     */
    EReference getRdbmsTableAlias_Table();

    /**
     * Returns the meta object for the container reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>View</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias#getView()
     * @see #getRdbmsTableAlias()
     * @generated
     */
    EReference getRdbmsTableAlias_View();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression <em>Label Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Label Expression</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression
     * @generated
     */
    EClass getRdbmsLabelExpression();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression#getText()
     * @see #getRdbmsLabelExpression()
     * @generated
     */
    EAttribute getRdbmsLabelExpression_Text();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression <em>Relation Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Relation Expression</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression
     * @generated
     */
    EClass getRdbmsRelationExpression();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression#getField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression#getField()
     * @see #getRdbmsRelationExpression()
     * @generated
     */
    EReference getRdbmsRelationExpression_Field();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField <em>View Alias Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Alias Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField
     * @generated
     */
    EClass getRdbmsViewAliasField();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField#getAlias <em>Alias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Alias</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField#getAlias()
     * @see #getRdbmsViewAliasField()
     * @generated
     */
    EReference getRdbmsViewAliasField_Alias();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation <em>Modify Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Modify Table Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation
     * @generated
     */
    EClass getRdbmsModifyTableOperation();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getCreateFieldOperations <em>Create Field Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Create Field Operations</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getCreateFieldOperations()
     * @see #getRdbmsModifyTableOperation()
     * @generated
     */
    EReference getRdbmsModifyTableOperation_CreateFieldOperations();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getModifyFieldOperations <em>Modify Field Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Modify Field Operations</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getModifyFieldOperations()
     * @see #getRdbmsModifyTableOperation()
     * @generated
     */
    EReference getRdbmsModifyTableOperation_ModifyFieldOperations();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getDeleteFieldOperations <em>Delete Field Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Delete Field Operations</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getDeleteFieldOperations()
     * @see #getRdbmsModifyTableOperation()
     * @generated
     */
    EReference getRdbmsModifyTableOperation_DeleteFieldOperations();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getPreviousTable <em>Previous Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Previous Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#getPreviousTable()
     * @see #getRdbmsModifyTableOperation()
     * @generated
     */
    EReference getRdbmsModifyTableOperation_PreviousTable();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#isNameChanged <em>Name Changed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name Changed</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation#isNameChanged()
     * @see #getRdbmsModifyTableOperation()
     * @generated
     */
    EAttribute getRdbmsModifyTableOperation_NameChanged();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation <em>Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation
     * @generated
     */
    EClass getRdbmsFieldOperation();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#getField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#getField()
     * @see #getRdbmsFieldOperation()
     * @generated
     */
    EReference getRdbmsFieldOperation_Field();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#isReviewRequired <em>Review Required</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Review Required</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation#isReviewRequired()
     * @see #getRdbmsFieldOperation()
     * @generated
     */
    EAttribute getRdbmsFieldOperation_ReviewRequired();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation <em>Create Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create Field Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation
     * @generated
     */
    EClass getRdbmsCreateFieldOperation();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation <em>Modify Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Modify Field Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation
     * @generated
     */
    EClass getRdbmsModifyFieldOperation();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isTypeChanged <em>Type Changed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Changed</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isTypeChanged()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_TypeChanged();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isMandatoryChanged <em>Mandatory Changed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mandatory Changed</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isMandatoryChanged()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_MandatoryChanged();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#getPreviousField <em>Previous Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Previous Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#getPreviousField()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EReference getRdbmsModifyFieldOperation_PreviousField();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isSizeChanged <em>Size Changed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size Changed</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isSizeChanged()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_SizeChanged();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isNameChanged <em>Name Changed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name Changed</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isNameChanged()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_NameChanged();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedValueFieldToForeignKey <em>Changed Value Field To Foreign Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Changed Value Field To Foreign Key</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedValueFieldToForeignKey()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_ChangedValueFieldToForeignKey();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedForeignKeyToValueField <em>Changed Foreign Key To Value Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Changed Foreign Key To Value Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation#isChangedForeignKeyToValueField()
     * @see #getRdbmsModifyFieldOperation()
     * @generated
     */
    EAttribute getRdbmsModifyFieldOperation_ChangedForeignKeyToValueField();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation <em>Delete Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delete Field Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation
     * @generated
     */
    EClass getRdbmsDeleteFieldOperation();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation <em>View Relation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Relation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation
     * @generated
     */
    EClass getRdbmsViewRelation();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromAlias <em>From Alias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>From Alias</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromAlias()
     * @see #getRdbmsViewRelation()
     * @generated
     */
    EReference getRdbmsViewRelation_FromAlias();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToAlias <em>To Alias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To Alias</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToAlias()
     * @see #getRdbmsViewRelation()
     * @generated
     */
    EReference getRdbmsViewRelation_ToAlias();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getName()
     * @see #getRdbmsViewRelation()
     * @generated
     */
    EAttribute getRdbmsViewRelation_Name();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromField <em>From Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>From Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getFromField()
     * @see #getRdbmsViewRelation()
     * @generated
     */
    EReference getRdbmsViewRelation_FromField();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToField <em>To Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation#getToField()
     * @see #getRdbmsViewRelation()
     * @generated
     */
    EReference getRdbmsViewRelation_ToField();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField <em>View Table Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Table Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField
     * @generated
     */
    EClass getRdbmsViewTableField();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#getTableField <em>Table Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Table Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#getTableField()
     * @see #getRdbmsViewTableField()
     * @generated
     */
    EReference getRdbmsViewTableField_TableField();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#isForeign <em>Foreign</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Foreign</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField#isForeign()
     * @see #getRdbmsViewTableField()
     * @generated
     */
    EAttribute getRdbmsViewTableField_Foreign();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField <em>View Foreign Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Foreign Identifier Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField
     * @generated
     */
    EClass getRdbmsViewForeignIdentifierField();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField#getReferenceIdentifier <em>Reference Identifier</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference Identifier</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField#getReferenceIdentifier()
     * @see #getRdbmsViewForeignIdentifierField()
     * @generated
     */
    EReference getRdbmsViewForeignIdentifierField_ReferenceIdentifier();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex <em>Index</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Index</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex
     * @generated
     */
    EClass getRdbmsIndex();

    /**
     * Returns the meta object for the container reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getTable()
     * @see #getRdbmsIndex()
     * @generated
     */
    EReference getRdbmsIndex_Table();

    /**
     * Returns the meta object for the reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Fields</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex#getFields()
     * @see #getRdbmsIndex()
     * @generated
     */
    EReference getRdbmsIndex_Fields();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex#isUnique <em>Unique</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unique</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex#isUnique()
     * @see #getRdbmsIndex()
     * @generated
     */
    EAttribute getRdbmsIndex_Unique();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord <em>View Record</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Record</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord
     * @generated
     */
    EClass getRdbmsViewRecord();

    /**
     * Returns the meta object for the containment reference list '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getValues()
     * @see #getRdbmsViewRecord()
     * @generated
     */
    EReference getRdbmsViewRecord_Values();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>View</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord#getView()
     * @see #getRdbmsViewRecord()
     * @generated
     */
    EReference getRdbmsViewRecord_View();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue <em>View Record Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Record Value</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue
     * @generated
     */
    EClass getRdbmsViewRecordValue();

    /**
     * Returns the meta object for the attribute '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValue()
     * @see #getRdbmsViewRecordValue()
     * @generated
     */
    EAttribute getRdbmsViewRecordValue_Value();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getIdentifierField <em>Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Identifier Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getIdentifierField()
     * @see #getRdbmsViewRecordValue()
     * @generated
     */
    EReference getRdbmsViewRecordValue_IdentifierField();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValueField <em>Value Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value Field</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue#getValueField()
     * @see #getRdbmsViewRecordValue()
     * @generated
     */
    EReference getRdbmsViewRecordValue_ValueField();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation <em>Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Table Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation
     * @generated
     */
    EClass getRdbmsTableOperation();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation#getTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Table</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation#getTable()
     * @see #getRdbmsTableOperation()
     * @generated
     */
    EReference getRdbmsTableOperation_Table();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation <em>Create Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create Table Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation
     * @generated
     */
    EClass getRdbmsCreateTableOperation();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation <em>Delete Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delete Table Operation</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation
     * @generated
     */
    EClass getRdbmsDeleteTableOperation();

    /**
     * Returns the meta object for class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta <em>Operation Meta</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Meta</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta
     * @generated
     */
    EClass getRdbmsOperationMeta();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getPreviousModel <em>Previous Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Previous Model</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getPreviousModel()
     * @see #getRdbmsOperationMeta()
     * @generated
     */
    EReference getRdbmsOperationMeta_PreviousModel();

    /**
     * Returns the meta object for the reference '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getCurrentModel <em>Current Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Current Model</em>'.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta#getCurrentModel()
     * @see #getRdbmsOperationMeta()
     * @generated
     */
    EReference getRdbmsOperationMeta_CurrentModel();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RdbmsFactory getRdbmsFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl <em>Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsElementImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsElement()
         * @generated
         */
        EClass RDBMS_ELEMENT = eINSTANCE.getRdbmsElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__NAME = eINSTANCE.getRdbmsElement_Name();

        /**
         * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__UUID = eINSTANCE.getRdbmsElement_Uuid();

        /**
         * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__SHORT_NAME = eINSTANCE.getRdbmsElement_ShortName();

        /**
         * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__FULL_NAME = eINSTANCE.getRdbmsElement_FullName();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__DESCRIPTION = eINSTANCE.getRdbmsElement_Description();

        /**
         * The meta object literal for the '<em><b>Sql Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__SQL_NAME = eINSTANCE.getRdbmsElement_SqlName();

        /**
         * The meta object literal for the '<em><b>Original Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__ORIGINAL_NAME = eINSTANCE.getRdbmsElement_OriginalName();

        /**
         * The meta object literal for the '<em><b>Original Package</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_ELEMENT__ORIGINAL_PACKAGE = eINSTANCE.getRdbmsElement_OriginalPackage();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl <em>Table</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTable()
         * @generated
         */
        EClass RDBMS_TABLE = eINSTANCE.getRdbmsTable();

        /**
         * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE__FIELDS = eINSTANCE.getRdbmsTable_Fields();

        /**
         * The meta object literal for the '<em><b>Unique Constraints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE__UNIQUE_CONSTRAINTS = eINSTANCE.getRdbmsTable_UniqueConstraints();

        /**
         * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE__PRIMARY_KEY = eINSTANCE.getRdbmsTable_PrimaryKey();

        /**
         * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE__INDEXES = eINSTANCE.getRdbmsTable_Indexes();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE__PARENT = eINSTANCE.getRdbmsTable_Parent();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl <em>Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsField()
         * @generated
         */
        EClass RDBMS_FIELD = eINSTANCE.getRdbmsField();

        /**
         * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_FIELD__TABLE = eINSTANCE.getRdbmsField_Table();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_FIELD__TYPE = eINSTANCE.getRdbmsField_Type();

        /**
         * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__MANDATORY = eINSTANCE.getRdbmsField_Mandatory();

        /**
         * The meta object literal for the '<em><b>Rdbms Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__RDBMS_TYPE_NAME = eINSTANCE.getRdbmsField_RdbmsTypeName();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__SIZE = eINSTANCE.getRdbmsField_Size();

        /**
         * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__PRECISION = eINSTANCE.getRdbmsField_Precision();

        /**
         * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__SCALE = eINSTANCE.getRdbmsField_Scale();

        /**
         * The meta object literal for the '<em><b>Storage Byte</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD__STORAGE_BYTE = eINSTANCE.getRdbmsField_StorageByte();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl <em>Foreign Key</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsForeignKeyImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsForeignKey()
         * @generated
         */
        EClass RDBMS_FOREIGN_KEY = eINSTANCE.getRdbmsForeignKey();

        /**
         * The meta object literal for the '<em><b>Reference Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_FOREIGN_KEY__REFERENCE_KEY = eINSTANCE.getRdbmsForeignKey_ReferenceKey();

        /**
         * The meta object literal for the '<em><b>Inheritence Based</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FOREIGN_KEY__INHERITENCE_BASED = eINSTANCE.getRdbmsForeignKey_InheritenceBased();

        /**
         * The meta object literal for the '<em><b>Foreign Key Sql Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FOREIGN_KEY__FOREIGN_KEY_SQL_NAME = eINSTANCE.getRdbmsForeignKey_ForeignKeySqlName();

        /**
         * The meta object literal for the '<em><b>Delete On Cascade</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FOREIGN_KEY__DELETE_ON_CASCADE = eINSTANCE.getRdbmsForeignKey_DeleteOnCascade();

        /**
         * The meta object literal for the '<em><b>Deferred</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FOREIGN_KEY__DEFERRED = eINSTANCE.getRdbmsForeignKey_Deferred();

        /**
         * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FOREIGN_KEY__READ_ONLY = eINSTANCE.getRdbmsForeignKey_ReadOnly();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl <em>Unique Constraint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsUniqueConstraintImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsUniqueConstraint()
         * @generated
         */
        EClass RDBMS_UNIQUE_CONSTRAINT = eINSTANCE.getRdbmsUniqueConstraint();

        /**
         * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_UNIQUE_CONSTRAINT__TABLE = eINSTANCE.getRdbmsUniqueConstraint_Table();

        /**
         * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_UNIQUE_CONSTRAINT__FIELDS = eINSTANCE.getRdbmsUniqueConstraint_Fields();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl <em>Junction Table</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsJunctionTableImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsJunctionTable()
         * @generated
         */
        EClass RDBMS_JUNCTION_TABLE = eINSTANCE.getRdbmsJunctionTable();

        /**
         * The meta object literal for the '<em><b>Field1</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_JUNCTION_TABLE__FIELD1 = eINSTANCE.getRdbmsJunctionTable_Field1();

        /**
         * The meta object literal for the '<em><b>Field2</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_JUNCTION_TABLE__FIELD2 = eINSTANCE.getRdbmsJunctionTable_Field2();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIdentifierFieldImpl <em>Identifier Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsIdentifierFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsIdentifierField()
         * @generated
         */
        EClass RDBMS_IDENTIFIER_FIELD = eINSTANCE.getRdbmsIdentifierField();

        /**
         * The meta object literal for the '<em><b>Foreign Keys</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_IDENTIFIER_FIELD__FOREIGN_KEYS = eINSTANCE.getRdbmsIdentifierField_ForeignKeys();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl <em>View</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsView()
         * @generated
         */
        EClass RDBMS_VIEW = eINSTANCE.getRdbmsView();

        /**
         * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW__FIELDS = eINSTANCE.getRdbmsView_Fields();

        /**
         * The meta object literal for the '<em><b>Primary Table</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW__PRIMARY_TABLE = eINSTANCE.getRdbmsView_PrimaryTable();

        /**
         * The meta object literal for the '<em><b>Origin Uuid</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW__ORIGIN_UUID = eINSTANCE.getRdbmsView_OriginUuid();

        /**
         * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW__RELATIONS = eINSTANCE.getRdbmsView_Relations();

        /**
         * The meta object literal for the '<em><b>Primary Identifier Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW__PRIMARY_IDENTIFIER_FIELD = eINSTANCE.getRdbmsView_PrimaryIdentifierField();

        /**
         * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW__TABLES = eINSTANCE.getRdbmsView_Tables();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl <em>View Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewField()
         * @generated
         */
        EClass RDBMS_VIEW_FIELD = eINSTANCE.getRdbmsViewField();

        /**
         * The meta object literal for the '<em><b>View</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_FIELD__VIEW = eINSTANCE.getRdbmsViewField_View();

        /**
         * The meta object literal for the '<em><b>Inherited</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW_FIELD__INHERITED = eINSTANCE.getRdbmsViewField_Inherited();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewValueFieldImpl <em>View Value Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewValueFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewValueField()
         * @generated
         */
        EClass RDBMS_VIEW_VALUE_FIELD = eINSTANCE.getRdbmsViewValueField();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl <em>View Expression Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewExpressionFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewExpressionField()
         * @generated
         */
        EClass RDBMS_VIEW_EXPRESSION_FIELD = eINSTANCE.getRdbmsViewExpressionField();

        /**
         * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSIONS = eINSTANCE.getRdbmsViewExpressionField_Expressions();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW_EXPRESSION_FIELD__EXPRESSION = eINSTANCE.getRdbmsViewExpressionField_Expression();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsExpressionImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsExpression()
         * @generated
         */
        EClass RDBMS_EXPRESSION = eINSTANCE.getRdbmsExpression();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_EXPRESSION__EXPRESSION = eINSTANCE.getRdbmsExpression_Expression();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl <em>Field Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldTypeImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFieldType()
         * @generated
         */
        EClass RDBMS_FIELD_TYPE = eINSTANCE.getRdbmsFieldType();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__NAME = eINSTANCE.getRdbmsFieldType_Name();

        /**
         * The meta object literal for the '<em><b>Rdbms Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__RDBMS_TYPE_NAME = eINSTANCE.getRdbmsFieldType_RdbmsTypeName();

        /**
         * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__UUID = eINSTANCE.getRdbmsFieldType_Uuid();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__DESCRIPTION = eINSTANCE.getRdbmsFieldType_Description();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__SIZE = eINSTANCE.getRdbmsFieldType_Size();

        /**
         * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__PRECISION = eINSTANCE.getRdbmsFieldType_Precision();

        /**
         * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__SCALE = eINSTANCE.getRdbmsFieldType_Scale();

        /**
         * The meta object literal for the '<em><b>Storage Byte</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_TYPE__STORAGE_BYTE = eINSTANCE.getRdbmsFieldType_StorageByte();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl <em>Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModelImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModel()
         * @generated
         */
        EClass RDBMS_MODEL = eINSTANCE.getRdbmsModel();

        /**
         * The meta object literal for the '<em><b>Rdbms Field Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__RDBMS_FIELD_TYPES = eINSTANCE.getRdbmsModel_RdbmsFieldTypes();

        /**
         * The meta object literal for the '<em><b>Rdbms Tables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__RDBMS_TABLES = eINSTANCE.getRdbmsModel_RdbmsTables();

        /**
         * The meta object literal for the '<em><b>Rdbms Views</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__RDBMS_VIEWS = eINSTANCE.getRdbmsModel_RdbmsViews();

        /**
         * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__CONFIGURATION = eINSTANCE.getRdbmsModel_Configuration();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODEL__VERSION = eINSTANCE.getRdbmsModel_Version();

        /**
         * The meta object literal for the '<em><b>Table Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__TABLE_OPERATIONS = eINSTANCE.getRdbmsModel_TableOperations();

        /**
         * The meta object literal for the '<em><b>View Records</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODEL__VIEW_RECORDS = eINSTANCE.getRdbmsModel_ViewRecords();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsValueFieldImpl <em>Value Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsValueFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsValueField()
         * @generated
         */
        EClass RDBMS_VALUE_FIELD = eINSTANCE.getRdbmsValueField();

        /**
         * The meta object literal for the '<em><b>Technical</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VALUE_FIELD__TECHNICAL = eINSTANCE.getRdbmsValueField_Technical();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewIdentifierFieldImpl <em>View Identifier Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewIdentifierFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewIdentifierField()
         * @generated
         */
        EClass RDBMS_VIEW_IDENTIFIER_FIELD = eINSTANCE.getRdbmsViewIdentifierField();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl <em>Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsConfigurationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsConfiguration()
         * @generated
         */
        EClass RDBMS_CONFIGURATION = eINSTANCE.getRdbmsConfiguration();

        /**
         * The meta object literal for the '<em><b>Dialect</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_CONFIGURATION__DIALECT = eINSTANCE.getRdbmsConfiguration_Dialect();

        /**
         * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_CONFIGURATION__FEATURES = eINSTANCE.getRdbmsConfiguration_Features();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFeatureImpl <em>Feature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFeatureImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFeature()
         * @generated
         */
        EClass RDBMS_FEATURE = eINSTANCE.getRdbmsFeature();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FEATURE__NAME = eINSTANCE.getRdbmsFeature_Name();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl <em>Table Alias</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableAliasImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTableAlias()
         * @generated
         */
        EClass RDBMS_TABLE_ALIAS = eINSTANCE.getRdbmsTableAlias();

        /**
         * The meta object literal for the '<em><b>Table</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE_ALIAS__TABLE = eINSTANCE.getRdbmsTableAlias_Table();

        /**
         * The meta object literal for the '<em><b>View</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE_ALIAS__VIEW = eINSTANCE.getRdbmsTableAlias_View();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsLabelExpressionImpl <em>Label Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsLabelExpressionImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsLabelExpression()
         * @generated
         */
        EClass RDBMS_LABEL_EXPRESSION = eINSTANCE.getRdbmsLabelExpression();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_LABEL_EXPRESSION__TEXT = eINSTANCE.getRdbmsLabelExpression_Text();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsRelationExpressionImpl <em>Relation Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsRelationExpressionImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsRelationExpression()
         * @generated
         */
        EClass RDBMS_RELATION_EXPRESSION = eINSTANCE.getRdbmsRelationExpression();

        /**
         * The meta object literal for the '<em><b>Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_RELATION_EXPRESSION__FIELD = eINSTANCE.getRdbmsRelationExpression_Field();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewAliasFieldImpl <em>View Alias Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewAliasFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewAliasField()
         * @generated
         */
        EClass RDBMS_VIEW_ALIAS_FIELD = eINSTANCE.getRdbmsViewAliasField();

        /**
         * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_ALIAS_FIELD__ALIAS = eINSTANCE.getRdbmsViewAliasField_Alias();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl <em>Modify Table Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyTableOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModifyTableOperation()
         * @generated
         */
        EClass RDBMS_MODIFY_TABLE_OPERATION = eINSTANCE.getRdbmsModifyTableOperation();

        /**
         * The meta object literal for the '<em><b>Create Field Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODIFY_TABLE_OPERATION__CREATE_FIELD_OPERATIONS = eINSTANCE.getRdbmsModifyTableOperation_CreateFieldOperations();

        /**
         * The meta object literal for the '<em><b>Modify Field Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODIFY_TABLE_OPERATION__MODIFY_FIELD_OPERATIONS = eINSTANCE.getRdbmsModifyTableOperation_ModifyFieldOperations();

        /**
         * The meta object literal for the '<em><b>Delete Field Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODIFY_TABLE_OPERATION__DELETE_FIELD_OPERATIONS = eINSTANCE.getRdbmsModifyTableOperation_DeleteFieldOperations();

        /**
         * The meta object literal for the '<em><b>Previous Table</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODIFY_TABLE_OPERATION__PREVIOUS_TABLE = eINSTANCE.getRdbmsModifyTableOperation_PreviousTable();

        /**
         * The meta object literal for the '<em><b>Name Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_TABLE_OPERATION__NAME_CHANGED = eINSTANCE.getRdbmsModifyTableOperation_NameChanged();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl <em>Field Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsFieldOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsFieldOperation()
         * @generated
         */
        EClass RDBMS_FIELD_OPERATION = eINSTANCE.getRdbmsFieldOperation();

        /**
         * The meta object literal for the '<em><b>Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_FIELD_OPERATION__FIELD = eINSTANCE.getRdbmsFieldOperation_Field();

        /**
         * The meta object literal for the '<em><b>Review Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_FIELD_OPERATION__REVIEW_REQUIRED = eINSTANCE.getRdbmsFieldOperation_ReviewRequired();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateFieldOperationImpl <em>Create Field Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateFieldOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsCreateFieldOperation()
         * @generated
         */
        EClass RDBMS_CREATE_FIELD_OPERATION = eINSTANCE.getRdbmsCreateFieldOperation();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl <em>Modify Field Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsModifyFieldOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsModifyFieldOperation()
         * @generated
         */
        EClass RDBMS_MODIFY_FIELD_OPERATION = eINSTANCE.getRdbmsModifyFieldOperation();

        /**
         * The meta object literal for the '<em><b>Type Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__TYPE_CHANGED = eINSTANCE.getRdbmsModifyFieldOperation_TypeChanged();

        /**
         * The meta object literal for the '<em><b>Mandatory Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__MANDATORY_CHANGED = eINSTANCE.getRdbmsModifyFieldOperation_MandatoryChanged();

        /**
         * The meta object literal for the '<em><b>Previous Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_MODIFY_FIELD_OPERATION__PREVIOUS_FIELD = eINSTANCE.getRdbmsModifyFieldOperation_PreviousField();

        /**
         * The meta object literal for the '<em><b>Size Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__SIZE_CHANGED = eINSTANCE.getRdbmsModifyFieldOperation_SizeChanged();

        /**
         * The meta object literal for the '<em><b>Name Changed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__NAME_CHANGED = eINSTANCE.getRdbmsModifyFieldOperation_NameChanged();

        /**
         * The meta object literal for the '<em><b>Changed Value Field To Foreign Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__CHANGED_VALUE_FIELD_TO_FOREIGN_KEY = eINSTANCE.getRdbmsModifyFieldOperation_ChangedValueFieldToForeignKey();

        /**
         * The meta object literal for the '<em><b>Changed Foreign Key To Value Field</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_MODIFY_FIELD_OPERATION__CHANGED_FOREIGN_KEY_TO_VALUE_FIELD = eINSTANCE.getRdbmsModifyFieldOperation_ChangedForeignKeyToValueField();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteFieldOperationImpl <em>Delete Field Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteFieldOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsDeleteFieldOperation()
         * @generated
         */
        EClass RDBMS_DELETE_FIELD_OPERATION = eINSTANCE.getRdbmsDeleteFieldOperation();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl <em>View Relation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRelationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRelation()
         * @generated
         */
        EClass RDBMS_VIEW_RELATION = eINSTANCE.getRdbmsViewRelation();

        /**
         * The meta object literal for the '<em><b>From Alias</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RELATION__FROM_ALIAS = eINSTANCE.getRdbmsViewRelation_FromAlias();

        /**
         * The meta object literal for the '<em><b>To Alias</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RELATION__TO_ALIAS = eINSTANCE.getRdbmsViewRelation_ToAlias();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW_RELATION__NAME = eINSTANCE.getRdbmsViewRelation_Name();

        /**
         * The meta object literal for the '<em><b>From Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RELATION__FROM_FIELD = eINSTANCE.getRdbmsViewRelation_FromField();

        /**
         * The meta object literal for the '<em><b>To Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RELATION__TO_FIELD = eINSTANCE.getRdbmsViewRelation_ToField();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl <em>View Table Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewTableFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewTableField()
         * @generated
         */
        EClass RDBMS_VIEW_TABLE_FIELD = eINSTANCE.getRdbmsViewTableField();

        /**
         * The meta object literal for the '<em><b>Table Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_TABLE_FIELD__TABLE_FIELD = eINSTANCE.getRdbmsViewTableField_TableField();

        /**
         * The meta object literal for the '<em><b>Foreign</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW_TABLE_FIELD__FOREIGN = eINSTANCE.getRdbmsViewTableField_Foreign();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewForeignIdentifierFieldImpl <em>View Foreign Identifier Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewForeignIdentifierFieldImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewForeignIdentifierField()
         * @generated
         */
        EClass RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD = eINSTANCE.getRdbmsViewForeignIdentifierField();

        /**
         * The meta object literal for the '<em><b>Reference Identifier</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD__REFERENCE_IDENTIFIER = eINSTANCE.getRdbmsViewForeignIdentifierField_ReferenceIdentifier();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl <em>Index</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsIndexImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsIndex()
         * @generated
         */
        EClass RDBMS_INDEX = eINSTANCE.getRdbmsIndex();

        /**
         * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_INDEX__TABLE = eINSTANCE.getRdbmsIndex_Table();

        /**
         * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_INDEX__FIELDS = eINSTANCE.getRdbmsIndex_Fields();

        /**
         * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_INDEX__UNIQUE = eINSTANCE.getRdbmsIndex_Unique();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl <em>View Record</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRecord()
         * @generated
         */
        EClass RDBMS_VIEW_RECORD = eINSTANCE.getRdbmsViewRecord();

        /**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RECORD__VALUES = eINSTANCE.getRdbmsViewRecord_Values();

        /**
         * The meta object literal for the '<em><b>View</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RECORD__VIEW = eINSTANCE.getRdbmsViewRecord_View();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl <em>View Record Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsViewRecordValueImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsViewRecordValue()
         * @generated
         */
        EClass RDBMS_VIEW_RECORD_VALUE = eINSTANCE.getRdbmsViewRecordValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RDBMS_VIEW_RECORD_VALUE__VALUE = eINSTANCE.getRdbmsViewRecordValue_Value();

        /**
         * The meta object literal for the '<em><b>Identifier Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RECORD_VALUE__IDENTIFIER_FIELD = eINSTANCE.getRdbmsViewRecordValue_IdentifierField();

        /**
         * The meta object literal for the '<em><b>Value Field</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_VIEW_RECORD_VALUE__VALUE_FIELD = eINSTANCE.getRdbmsViewRecordValue_ValueField();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableOperationImpl <em>Table Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsTableOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsTableOperation()
         * @generated
         */
        EClass RDBMS_TABLE_OPERATION = eINSTANCE.getRdbmsTableOperation();

        /**
         * The meta object literal for the '<em><b>Table</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_TABLE_OPERATION__TABLE = eINSTANCE.getRdbmsTableOperation_Table();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateTableOperationImpl <em>Create Table Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsCreateTableOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsCreateTableOperation()
         * @generated
         */
        EClass RDBMS_CREATE_TABLE_OPERATION = eINSTANCE.getRdbmsCreateTableOperation();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteTableOperationImpl <em>Delete Table Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsDeleteTableOperationImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsDeleteTableOperation()
         * @generated
         */
        EClass RDBMS_DELETE_TABLE_OPERATION = eINSTANCE.getRdbmsDeleteTableOperation();

        /**
         * The meta object literal for the '{@link hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl <em>Operation Meta</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsOperationMetaImpl
         * @see hu.blackbelt.judo.meta.rdbms.impl.RdbmsPackageImpl#getRdbmsOperationMeta()
         * @generated
         */
        EClass RDBMS_OPERATION_META = eINSTANCE.getRdbmsOperationMeta();

        /**
         * The meta object literal for the '<em><b>Previous Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_OPERATION_META__PREVIOUS_MODEL = eINSTANCE.getRdbmsOperationMeta_PreviousModel();

        /**
         * The meta object literal for the '<em><b>Current Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RDBMS_OPERATION_META__CURRENT_MODEL = eINSTANCE.getRdbmsOperationMeta_CurrentModel();

    }

} //RdbmsPackage
