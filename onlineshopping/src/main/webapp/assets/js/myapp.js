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
})