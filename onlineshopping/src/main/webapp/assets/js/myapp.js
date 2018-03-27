$(function () {
    // solving the active menu problem
    switch (menu) {
        case 'About us':
            $('#about').addClass('nav-item active');
            break;
        case 'Contact us':
            $('#contact').addClass('nav-item active');
            break;
        default:
            $('#home').addClass('nav-item active');
            break;
    }
})