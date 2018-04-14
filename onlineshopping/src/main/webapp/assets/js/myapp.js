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
                            str += '<a href="javascript void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
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
})