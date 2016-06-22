Ext.define('Ozmin.models.grid.MineralResource', {
    extend : 'Ozmin.models.Base',

    fields : [ 'id', 'recordDate', 'oreUnit', 'proven', 'probable',
            'provenAndProbable', 'measured', 'indicated',
            'measuredAndIndicated', 'inferred', 'other',
            {name: 'mineralisedZoneName', mapping: 'mineralisedZone.name'},
            {name: 'mineralisedZone.mineralDeposit.name', mapping: 'mineralisedZone.mineralDeposit.name'}],

    belongsTo : 'MineralisedZone'
});