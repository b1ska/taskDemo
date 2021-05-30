Ext.require(['Ext.grid.*', 'Ext.data.*', 'Ext.dd.*']);


Ext.define('UserDataModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'userId', type: 'int'},
        {name: 'userName', type: 'string'},
        {name: 'userSex', type: 'string'},
        {name: 'userYearOfBirthDay', type: 'int'},
        {name: 'userEmail', type: 'string'}
    ]
});

Ext.onReady(function () {

    var firstGridStore = Ext.create('Ext.data.Store', {
        model: 'UserDataModel',
        pageSize: 30,
        proxy: {
            type: 'ajax',
            api: {
                read: 'http://localhost:8089/userlist', //поиск
                create: 'http://localhost:8089/addUser',
                // update: 'http://localhost:8089/updateUsers'
            },
            reader: {
                type: 'json',
                rootProperty: "MyModel"
            },
            writer: {
                type: 'json',
           //      rootProperty: "id",
           //      allowSingle: true,
           //      encode: true,
           // //     listful: true,
           //      writeAllFields: true
            }



        },
        autoLoad: true
    });

    // Creation the grid
    var firstGrid = Ext.create('Ext.grid.Panel', {

        store: firstGridStore,
        columns: [
            {
                header: 'Id',
                dataIndex: 'userId',
                id: 'userId',
                flex: 1,
                sortable: true,
                editor: 'numberfield'
            },
            {
                header: 'Имя пользователя',
                dataIndex: 'userName',
                id: 'userName',
                flex: 1,
                sortable: true,
                editor: 'textfield'
            },
            {
                header: 'Пол',
                dataIndex: 'userSex',
                id: 'userSex',
                flex: 1,
                sortable: true,
                editor: 'textfield'
            },
            {
                header: 'Дата рождения',
                dataIndex: 'userYearOfBirthDay',
                id: 'userYearOfBirthDay',
                flex: 1,
                sortable: true,
                editor: 'numberfield'
            },
            {
                header: 'Почта',
                dataIndex: 'userEmail',
                id: 'userEmail',
                flex: 1,
                sortable: true,
                editor: 'textfield'
            }
        ],
        plugins: {
            ptype: 'cellediting',
            clicksToEdit: 1
        },
        stripeRows: true,
        title: 'Таблица пользователей',
        margins: '0 2 0 0'
    });

    var rEditor = Ext.create('Ext.grid.plugin.RowEditing', {
        clicksToEdit: 2,
        listeners:
            {
                edit: function (editor, e) {
                }
            }
    });


    // Creation of a panel.
    var displayPanel = Ext.create('Ext.Panel', {

        width: 800,
        height: 400,
        layout: {
            type: 'hbox',
            align: 'stretch',
            padding: 5
        },
        renderTo: 'panel',
        defaults: {
            flex: 1
        },
        items: [firstGrid],
        dockedItems:
            {
                xtype: 'toolbar',
                dock: 'bottom',
                items: ['->',
                    {
                        xtype: 'button',
                        border: true,
                        text: 'Add User',
                        listeners:
                            {
                                click:
                                    {
                                        fn: function () {
                                            firstGridStore.insert(0, new UserDataModel());
                                            rEditor.startEdit(0, 0);
                                        }
                                    }
                            }
                    },
                    {
                        xtype: 'button',
                        border: true,
                        text: 'Сохранить',
                        listeners:
                            {
                                click:
                                    {
                                        fn: function () {
                                            firstGridStore.sync();
                                        }
                                    }
                            }
                    }
                ]
            }
    });
});