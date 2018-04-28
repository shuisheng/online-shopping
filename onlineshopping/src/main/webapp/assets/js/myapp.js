$(function () {
    // solving the active menu problem
    switch (menu) {
        case 'About us':
            $('#about').addClass('active');
            break;
        case 'Contact us':
            $('#contact').addClass('active');
            break;
        case 'All Products':
            $('#listProducts').addClass('active');
            break;
        case 'Manage Products':
            $('#manageProducts').addClass('active');
            break;
        default:
            $('#listProducts').addClass('active');
            $('#a_'+menu).addClass('active');
            break;
    }

    // code for jquery dataTable
    // create a dataset
    var products = [
        ['1', 'ABC'],
        ['2', 'SSD'],
        ['3', 'XXD'],
        ['4', 'FFF'],
        ['5', '333'],
        ['6', 'CCC'],
        ['7', 'GDG'],
        ['8', 'XKL']
    ];


    var jsonUrl = '';
    if(window.categoryId == '') {
        jsonUrl = window.contextRoot + '/json/data/all/products';
    } else {
        jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
    }

    // code for jquery dataTable
    var $table = $('#productListTable');
    $table.blur();
    if ($table.length) {
        console.error('Inside the table!');
        $table.DataTable({
            lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
            pageLength: 5,
            //data: products
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                  data: 'code',
                  mRender: function (data, type, row) {
                      return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImg"/>';
                  }  
                },
                {data: 'name'},
                {data: 'brand'},
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '¥' + data;
                    }
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</span>';
                        }
                        return data;
                    }
                },
                {
                    data: 'id',
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="' + window.contextRoot + '/show/' + data +
                            '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
                        if (row.quantity < 1) {
                            str += '<a href="javascript void(0)" class="btn btn-success disabled"><span ' +
                                'class="glyphicon glyphicon-shopping-cart"></span></a>';
                        } else {
                            str += '<a href="' + window.constructor + '/cart/add' + data +
                                '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                        }

                        return str;
                    }
                }
            ]
        });
    }

    // dismissing the alert after 3 times
    var $alert = $('.alert');

    if ($alert.length) {
        setTimeout(function() {
            $alert.fadeOut('slow');
        }, 300);
    }

    // ---------------------
    $('.switch input[type="checkbox"]').on('change', function() {
        var checkbox = $(this);
        var checked = checkbox.prop('checked');
        var dMsg = (checked) ? 'You want to activate the product?' : 'You want to deactivate the product?';
        var value = checkbox.prop('value');

        bootbox.confirm({
            size: 'medium',
            title: 'Product Activate & Deactivate',
            message: dMsg,
            callback: function(confirmed) {
                if (confirmed) {
                    console.log(value);
                    bootbox.alert({
                        size: 'medium',
                        title: 'Information',
                        message: 'You are going to perform operation on product' + value
                    })
                } else {
                    checkbox.prop('checked', !checked);
                }
            }
        })
    })

    // data table for admin
    var $adminProductsTable = $('#adminProductsTable');
    if ($adminProductsTable.length) {
        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
        $adminProductsTable.DataTable({
            lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
            pageLength: 5,
            //data: products
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {data: 'id'},
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
                    }
                },
                {data: 'name'},
                {data: 'brand'},
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</span>';
                        }
                        return data;
                    }
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '¥' + data;
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';

                        str = '<label class="switch">';
                        if (data) {
                            str += '<input type="checkbox" checked="checked" value="' + row.id +'" />';
                        } else {
                            str += '<input type="checkbox" value="' + row.id +'" />';
                        }
                        str += '<div class="slider"> </div></label>';

                        return str;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '<a href="' + window.contextRoot + '/manage/'+ data + '/product" class="btn btn-warning">\n' +
                            '<span class="glyphicon glyphicon-pencil" ></span>\n' +
                            '</a>';
                        return str;
                    }
                }
            ],

            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function() {
                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'You want to activate the product?' : 'You want to deactivate the product?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activate & Deactivate',
                        message: dMsg,
                        callback: function(confirmed) {
                            if (confirmed) {
                                console.log(value);
                                var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
                                $.post(activationUrl, function (data) {
                                    bootbox.alert({
                                        size: 'medium',
                                        title: 'Information',
                                        message: data
                                    })
                                })

                            } else {
                                checkbox.prop('checked', !checked);
                            }
                        }
                    })
                })
            }
        });
    }

    // validation code for categoryForm

    var $categoryForm = $('#categoryForm');
    if ($categoryForm.length) {
        $categoryForm.validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2
                },
                description: {
                    required: true
                }
            },
            message: {
                name: {
                    required: 'please add the category name!',
                    minlength: 'the category name should not be less than 2 characters!'
                },
                description: {
                    required: 'please add a description for this category!'
                }
            },
            errorElement: 'em',
            errorPlacement: function (error, element) {
                error.addClass('help-block');
                error.insertAfter(element);
            }
        })
    }
})