Ext.require([ 'Ext.grid.*', 'Ext.data.*', 'Ext.dd.*' ]);

// Creation of data model
Ext.define('UserDataModel', {
    extend : 'Ext.data.Model',
    fields : [ {
        name : 'id',
        mapping : 'id'
    },

        {
            name : 'name',
            mapping : 'name'
        }, {
            name : 'sex',
            mapping : 'sex'
        },{
            name : 'age',
            mapping : 'age'
        },{
            name : 'email',
            mapping : 'email'
        } ]
});

Ext.onReady(function() {
    // Store data
    var myData = [ {
        id:"1",
        name : "Danila",
        sex: "male",
        age : "33",
        email: "test@mail.ru"
    }, {
        id:"2",
        name : "Tom",
        sex: "male",
        age : "40",
        email: "test@gmail.com"
    }, {
        id:"3",
        name : "Andrey",
        sex: "male",
        age : "25",
        email: "test3@yandex.ru"
    }, {
        id:"4",
        name : "Vaso",
        sex: "male",
        age : "26",
        email: "test@mail.ru"
    }, {
        id:"5",
        name : "Lalal",
        sex: "female",
        age : "22",
        email: "test2@list.ru"
    } ];

    // Creation grid store
    var firstGridStore = Ext.create('Ext.data.Store', {
        model : 'UserDataModel',
        data : myData
    });

    // Creation the grid
    var firstGrid = Ext.create('Ext.grid.Panel', {
        multiSelect : true,
        viewConfig : {
            plugins : {
                ptype : 'gridviewdragdrop',
                dragGroup : 'firstGridDDGroup'
            },
            listeners : {
                drop : function(node, data, dropRec, dropPosition) {
                    var dropOn = dropRec ? ' ' + dropPosition + ' '
                        + dropRec.get('name') : ' on empty view';
                }
            }
        },
        store : firstGridStore,
        columns : [ {
            header : "Id",
            dataIndex : 'id',
            id : 'id',
            flex : 1,
            sortable : true
        }, {
            header : "Name",
            dataIndex : 'name',
            id : 'name',
            flex : 1,
            sortable : true
        },{
            header : "Sex",
            dataIndex : 'sex',
            id : 'sex',
            flex : 1,
            sortable : true
        },{
            header : "Age",
            dataIndex : 'age',
            id: 'sex',
            flex : 1,
            sortable : true
        }, {
            header : "Email",
            dataIndex : 'email',
            id: 'email',
            flex : 1,
            sortable : true
        } ],
        stripeRows : true,
        title : 'User Grid',
        margins : '0 2 0 0'
    });

    // Creation of a panel.
    var displayPanel = Ext.create('Ext.Panel', {
        width : 800,
        height : 400,
        layout : {
            type : 'hbox',
            align : 'stretch',
            padding : 5
        },
        renderTo : 'panel',
        defaults : {
            flex : 1
        },
        items : [ firstGrid],
        dockedItems : {
            xtype : 'toolbar',
            dock : 'bottom',
            items : [ '->', {
                text : 'Add User',
                handler : function() {
                    firstGridStore.loadData(myData);
                   // Todo adduser;
                }
            } ]
        }
    });
});