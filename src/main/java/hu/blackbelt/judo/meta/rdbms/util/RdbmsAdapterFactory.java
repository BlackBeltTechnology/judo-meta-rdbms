/**
 */
package hu.blackbelt.judo.meta.rdbms.util;

import hu.blackbelt.judo.meta.rdbms.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hu.blackbelt.judo.meta.rdbms.RdbmsPackage
 * @generated
 */
public class RdbmsAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static RdbmsPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RdbmsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RdbmsPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RdbmsSwitch<Adapter> modelSwitch =
        new RdbmsSwitch<Adapter>() {
            @Override
            public Adapter caseRdbmsElement(RdbmsElement object) {
                return createRdbmsElementAdapter();
            }
            @Override
            public Adapter caseRdbmsTable(RdbmsTable object) {
                return createRdbmsTableAdapter();
            }
            @Override
            public Adapter caseRdbmsField(RdbmsField object) {
                return createRdbmsFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsForeignKey(RdbmsForeignKey object) {
                return createRdbmsForeignKeyAdapter();
            }
            @Override
            public Adapter caseRdbmsUniqueConstraint(RdbmsUniqueConstraint object) {
                return createRdbmsUniqueConstraintAdapter();
            }
            @Override
            public Adapter caseRdbmsJunctionTable(RdbmsJunctionTable object) {
                return createRdbmsJunctionTableAdapter();
            }
            @Override
            public Adapter caseRdbmsIdentifierField(RdbmsIdentifierField object) {
                return createRdbmsIdentifierFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsView(RdbmsView object) {
                return createRdbmsViewAdapter();
            }
            @Override
            public Adapter caseRdbmsViewField(RdbmsViewField object) {
                return createRdbmsViewFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsViewValueField(RdbmsViewValueField object) {
                return createRdbmsViewValueFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsViewExpressionField(RdbmsViewExpressionField object) {
                return createRdbmsViewExpressionFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsExpression(RdbmsExpression object) {
                return createRdbmsExpressionAdapter();
            }
            @Override
            public Adapter caseRdbmsFieldType(RdbmsFieldType object) {
                return createRdbmsFieldTypeAdapter();
            }
            @Override
            public Adapter caseRdbmsModel(RdbmsModel object) {
                return createRdbmsModelAdapter();
            }
            @Override
            public Adapter caseRdbmsValueField(RdbmsValueField object) {
                return createRdbmsValueFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsViewIdentifierField(RdbmsViewIdentifierField object) {
                return createRdbmsViewIdentifierFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsConfiguration(RdbmsConfiguration object) {
                return createRdbmsConfigurationAdapter();
            }
            @Override
            public Adapter caseRdbmsFeature(RdbmsFeature object) {
                return createRdbmsFeatureAdapter();
            }
            @Override
            public Adapter caseRdbmsTableAlias(RdbmsTableAlias object) {
                return createRdbmsTableAliasAdapter();
            }
            @Override
            public Adapter caseRdbmsLabelExpression(RdbmsLabelExpression object) {
                return createRdbmsLabelExpressionAdapter();
            }
            @Override
            public Adapter caseRdbmsRelationExpression(RdbmsRelationExpression object) {
                return createRdbmsRelationExpressionAdapter();
            }
            @Override
            public Adapter caseRdbmsViewAliasField(RdbmsViewAliasField object) {
                return createRdbmsViewAliasFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsModifyTableOperation(RdbmsModifyTableOperation object) {
                return createRdbmsModifyTableOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsFieldOperation(RdbmsFieldOperation object) {
                return createRdbmsFieldOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsCreateFieldOperation(RdbmsCreateFieldOperation object) {
                return createRdbmsCreateFieldOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsModifyFieldOperation(RdbmsModifyFieldOperation object) {
                return createRdbmsModifyFieldOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsDeleteFieldOperation(RdbmsDeleteFieldOperation object) {
                return createRdbmsDeleteFieldOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsViewRelation(RdbmsViewRelation object) {
                return createRdbmsViewRelationAdapter();
            }
            @Override
            public Adapter caseRdbmsViewTableField(RdbmsViewTableField object) {
                return createRdbmsViewTableFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsViewForeignIdentifierField(RdbmsViewForeignIdentifierField object) {
                return createRdbmsViewForeignIdentifierFieldAdapter();
            }
            @Override
            public Adapter caseRdbmsIndex(RdbmsIndex object) {
                return createRdbmsIndexAdapter();
            }
            @Override
            public Adapter caseRdbmsViewRecord(RdbmsViewRecord object) {
                return createRdbmsViewRecordAdapter();
            }
            @Override
            public Adapter caseRdbmsViewRecordValue(RdbmsViewRecordValue object) {
                return createRdbmsViewRecordValueAdapter();
            }
            @Override
            public Adapter caseRdbmsTableOperation(RdbmsTableOperation object) {
                return createRdbmsTableOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsCreateTableOperation(RdbmsCreateTableOperation object) {
                return createRdbmsCreateTableOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsDeleteTableOperation(RdbmsDeleteTableOperation object) {
                return createRdbmsDeleteTableOperationAdapter();
            }
            @Override
            public Adapter caseRdbmsOperationMeta(RdbmsOperationMeta object) {
                return createRdbmsOperationMetaAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsElement
     * @generated
     */
    public Adapter createRdbmsElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTable <em>Table</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTable
     * @generated
     */
    public Adapter createRdbmsTableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsField
     * @generated
     */
    public Adapter createRdbmsFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey <em>Foreign Key</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey
     * @generated
     */
    public Adapter createRdbmsForeignKeyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint <em>Unique Constraint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint
     * @generated
     */
    public Adapter createRdbmsUniqueConstraintAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable <em>Junction Table</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable
     * @generated
     */
    public Adapter createRdbmsJunctionTableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField <em>Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField
     * @generated
     */
    public Adapter createRdbmsIdentifierFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsView
     * @generated
     */
    public Adapter createRdbmsViewAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewField <em>View Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewField
     * @generated
     */
    public Adapter createRdbmsViewFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField <em>View Value Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewValueField
     * @generated
     */
    public Adapter createRdbmsViewValueFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField <em>View Expression Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewExpressionField
     * @generated
     */
    public Adapter createRdbmsViewExpressionFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsExpression
     * @generated
     */
    public Adapter createRdbmsExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldType <em>Field Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldType
     * @generated
     */
    public Adapter createRdbmsFieldTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModel <em>Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModel
     * @generated
     */
    public Adapter createRdbmsModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsValueField <em>Value Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsValueField
     * @generated
     */
    public Adapter createRdbmsValueFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField <em>View Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewIdentifierField
     * @generated
     */
    public Adapter createRdbmsViewIdentifierFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration
     * @generated
     */
    public Adapter createRdbmsConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFeature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFeature
     * @generated
     */
    public Adapter createRdbmsFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias <em>Table Alias</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableAlias
     * @generated
     */
    public Adapter createRdbmsTableAliasAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression <em>Label Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsLabelExpression
     * @generated
     */
    public Adapter createRdbmsLabelExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression <em>Relation Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsRelationExpression
     * @generated
     */
    public Adapter createRdbmsRelationExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField <em>View Alias Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewAliasField
     * @generated
     */
    public Adapter createRdbmsViewAliasFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation <em>Modify Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation
     * @generated
     */
    public Adapter createRdbmsModifyTableOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation <em>Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsFieldOperation
     * @generated
     */
    public Adapter createRdbmsFieldOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation <em>Create Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation
     * @generated
     */
    public Adapter createRdbmsCreateFieldOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation <em>Modify Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation
     * @generated
     */
    public Adapter createRdbmsModifyFieldOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation <em>Delete Field Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation
     * @generated
     */
    public Adapter createRdbmsDeleteFieldOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation <em>View Relation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRelation
     * @generated
     */
    public Adapter createRdbmsViewRelationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField <em>View Table Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewTableField
     * @generated
     */
    public Adapter createRdbmsViewTableFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField <em>View Foreign Identifier Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewForeignIdentifierField
     * @generated
     */
    public Adapter createRdbmsViewForeignIdentifierFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsIndex <em>Index</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsIndex
     * @generated
     */
    public Adapter createRdbmsIndexAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord <em>View Record</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecord
     * @generated
     */
    public Adapter createRdbmsViewRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue <em>View Record Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsViewRecordValue
     * @generated
     */
    public Adapter createRdbmsViewRecordValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation <em>Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation
     * @generated
     */
    public Adapter createRdbmsTableOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation <em>Create Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation
     * @generated
     */
    public Adapter createRdbmsCreateTableOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation <em>Delete Table Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation
     * @generated
     */
    public Adapter createRdbmsDeleteTableOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta <em>Operation Meta</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta
     * @generated
     */
    public Adapter createRdbmsOperationMetaAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //RdbmsAdapterFactory
