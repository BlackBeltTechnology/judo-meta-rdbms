/**
 */
package hu.blackbelt.judo.meta.rdbms.impl;

import hu.blackbelt.judo.meta.rdbms.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RdbmsFactoryImpl extends EFactoryImpl implements RdbmsFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RdbmsFactory init() {
        try {
            RdbmsFactory theRdbmsFactory = (RdbmsFactory)EPackage.Registry.INSTANCE.getEFactory(RdbmsPackage.eNS_URI);
            if (theRdbmsFactory != null) {
                return theRdbmsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RdbmsFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case RdbmsPackage.RDBMS_TABLE: return createRdbmsTable();
            case RdbmsPackage.RDBMS_FOREIGN_KEY: return createRdbmsForeignKey();
            case RdbmsPackage.RDBMS_UNIQUE_CONSTRAINT: return createRdbmsUniqueConstraint();
            case RdbmsPackage.RDBMS_JUNCTION_TABLE: return createRdbmsJunctionTable();
            case RdbmsPackage.RDBMS_IDENTIFIER_FIELD: return createRdbmsIdentifierField();
            case RdbmsPackage.RDBMS_VIEW: return createRdbmsView();
            case RdbmsPackage.RDBMS_VIEW_VALUE_FIELD: return createRdbmsViewValueField();
            case RdbmsPackage.RDBMS_VIEW_EXPRESSION_FIELD: return createRdbmsViewExpressionField();
            case RdbmsPackage.RDBMS_FIELD_TYPE: return createRdbmsFieldType();
            case RdbmsPackage.RDBMS_MODEL: return createRdbmsModel();
            case RdbmsPackage.RDBMS_VALUE_FIELD: return createRdbmsValueField();
            case RdbmsPackage.RDBMS_VIEW_IDENTIFIER_FIELD: return createRdbmsViewIdentifierField();
            case RdbmsPackage.RDBMS_CONFIGURATION: return createRdbmsConfiguration();
            case RdbmsPackage.RDBMS_FEATURE: return createRdbmsFeature();
            case RdbmsPackage.RDBMS_TABLE_ALIAS: return createRdbmsTableAlias();
            case RdbmsPackage.RDBMS_LABEL_EXPRESSION: return createRdbmsLabelExpression();
            case RdbmsPackage.RDBMS_RELATION_EXPRESSION: return createRdbmsRelationExpression();
            case RdbmsPackage.RDBMS_MODIFY_TABLE_OPERATION: return createRdbmsModifyTableOperation();
            case RdbmsPackage.RDBMS_CREATE_FIELD_OPERATION: return createRdbmsCreateFieldOperation();
            case RdbmsPackage.RDBMS_MODIFY_FIELD_OPERATION: return createRdbmsModifyFieldOperation();
            case RdbmsPackage.RDBMS_DELETE_FIELD_OPERATION: return createRdbmsDeleteFieldOperation();
            case RdbmsPackage.RDBMS_VIEW_RELATION: return createRdbmsViewRelation();
            case RdbmsPackage.RDBMS_VIEW_FOREIGN_IDENTIFIER_FIELD: return createRdbmsViewForeignIdentifierField();
            case RdbmsPackage.RDBMS_INDEX: return createRdbmsIndex();
            case RdbmsPackage.RDBMS_VIEW_RECORD: return createRdbmsViewRecord();
            case RdbmsPackage.RDBMS_VIEW_RECORD_VALUE: return createRdbmsViewRecordValue();
            case RdbmsPackage.RDBMS_CREATE_TABLE_OPERATION: return createRdbmsCreateTableOperation();
            case RdbmsPackage.RDBMS_DELETE_TABLE_OPERATION: return createRdbmsDeleteTableOperation();
            case RdbmsPackage.RDBMS_OPERATION_META: return createRdbmsOperationMeta();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTable createRdbmsTable() {
        RdbmsTableImpl rdbmsTable = new RdbmsTableImpl();
        return rdbmsTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsForeignKey createRdbmsForeignKey() {
        RdbmsForeignKeyImpl rdbmsForeignKey = new RdbmsForeignKeyImpl();
        return rdbmsForeignKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsUniqueConstraint createRdbmsUniqueConstraint() {
        RdbmsUniqueConstraintImpl rdbmsUniqueConstraint = new RdbmsUniqueConstraintImpl();
        return rdbmsUniqueConstraint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsJunctionTable createRdbmsJunctionTable() {
        RdbmsJunctionTableImpl rdbmsJunctionTable = new RdbmsJunctionTableImpl();
        return rdbmsJunctionTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIdentifierField createRdbmsIdentifierField() {
        RdbmsIdentifierFieldImpl rdbmsIdentifierField = new RdbmsIdentifierFieldImpl();
        return rdbmsIdentifierField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsView createRdbmsView() {
        RdbmsViewImpl rdbmsView = new RdbmsViewImpl();
        return rdbmsView;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewValueField createRdbmsViewValueField() {
        RdbmsViewValueFieldImpl rdbmsViewValueField = new RdbmsViewValueFieldImpl();
        return rdbmsViewValueField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewExpressionField createRdbmsViewExpressionField() {
        RdbmsViewExpressionFieldImpl rdbmsViewExpressionField = new RdbmsViewExpressionFieldImpl();
        return rdbmsViewExpressionField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFieldType createRdbmsFieldType() {
        RdbmsFieldTypeImpl rdbmsFieldType = new RdbmsFieldTypeImpl();
        return rdbmsFieldType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModel createRdbmsModel() {
        RdbmsModelImpl rdbmsModel = new RdbmsModelImpl();
        return rdbmsModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsValueField createRdbmsValueField() {
        RdbmsValueFieldImpl rdbmsValueField = new RdbmsValueFieldImpl();
        return rdbmsValueField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewIdentifierField createRdbmsViewIdentifierField() {
        RdbmsViewIdentifierFieldImpl rdbmsViewIdentifierField = new RdbmsViewIdentifierFieldImpl();
        return rdbmsViewIdentifierField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsConfiguration createRdbmsConfiguration() {
        RdbmsConfigurationImpl rdbmsConfiguration = new RdbmsConfigurationImpl();
        return rdbmsConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsFeature createRdbmsFeature() {
        RdbmsFeatureImpl rdbmsFeature = new RdbmsFeatureImpl();
        return rdbmsFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsTableAlias createRdbmsTableAlias() {
        RdbmsTableAliasImpl rdbmsTableAlias = new RdbmsTableAliasImpl();
        return rdbmsTableAlias;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsLabelExpression createRdbmsLabelExpression() {
        RdbmsLabelExpressionImpl rdbmsLabelExpression = new RdbmsLabelExpressionImpl();
        return rdbmsLabelExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsRelationExpression createRdbmsRelationExpression() {
        RdbmsRelationExpressionImpl rdbmsRelationExpression = new RdbmsRelationExpressionImpl();
        return rdbmsRelationExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModifyTableOperation createRdbmsModifyTableOperation() {
        RdbmsModifyTableOperationImpl rdbmsModifyTableOperation = new RdbmsModifyTableOperationImpl();
        return rdbmsModifyTableOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsCreateFieldOperation createRdbmsCreateFieldOperation() {
        RdbmsCreateFieldOperationImpl rdbmsCreateFieldOperation = new RdbmsCreateFieldOperationImpl();
        return rdbmsCreateFieldOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsModifyFieldOperation createRdbmsModifyFieldOperation() {
        RdbmsModifyFieldOperationImpl rdbmsModifyFieldOperation = new RdbmsModifyFieldOperationImpl();
        return rdbmsModifyFieldOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsDeleteFieldOperation createRdbmsDeleteFieldOperation() {
        RdbmsDeleteFieldOperationImpl rdbmsDeleteFieldOperation = new RdbmsDeleteFieldOperationImpl();
        return rdbmsDeleteFieldOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewRelation createRdbmsViewRelation() {
        RdbmsViewRelationImpl rdbmsViewRelation = new RdbmsViewRelationImpl();
        return rdbmsViewRelation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewForeignIdentifierField createRdbmsViewForeignIdentifierField() {
        RdbmsViewForeignIdentifierFieldImpl rdbmsViewForeignIdentifierField = new RdbmsViewForeignIdentifierFieldImpl();
        return rdbmsViewForeignIdentifierField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsIndex createRdbmsIndex() {
        RdbmsIndexImpl rdbmsIndex = new RdbmsIndexImpl();
        return rdbmsIndex;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewRecord createRdbmsViewRecord() {
        RdbmsViewRecordImpl rdbmsViewRecord = new RdbmsViewRecordImpl();
        return rdbmsViewRecord;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsViewRecordValue createRdbmsViewRecordValue() {
        RdbmsViewRecordValueImpl rdbmsViewRecordValue = new RdbmsViewRecordValueImpl();
        return rdbmsViewRecordValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsCreateTableOperation createRdbmsCreateTableOperation() {
        RdbmsCreateTableOperationImpl rdbmsCreateTableOperation = new RdbmsCreateTableOperationImpl();
        return rdbmsCreateTableOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsDeleteTableOperation createRdbmsDeleteTableOperation() {
        RdbmsDeleteTableOperationImpl rdbmsDeleteTableOperation = new RdbmsDeleteTableOperationImpl();
        return rdbmsDeleteTableOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsOperationMeta createRdbmsOperationMeta() {
        RdbmsOperationMetaImpl rdbmsOperationMeta = new RdbmsOperationMetaImpl();
        return rdbmsOperationMeta;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsPackage getRdbmsPackage() {
        return (RdbmsPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RdbmsPackage getPackage() {
        return RdbmsPackage.eINSTANCE;
    }

} //RdbmsFactoryImpl
