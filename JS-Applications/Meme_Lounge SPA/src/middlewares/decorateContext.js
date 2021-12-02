import { logout } from '../api/api.js';
import { page ,render  } from '../lib.js';
import { getUserData } from '../util.js';

const root = document.querySelector('main');
document.getElementById('logoutBtn').addEventListener('click',onLogout);

export default function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    
    next();
};

export function updateUserNav() {
    const userData = getUserData();

    if (userData) {
        document.querySelector('nav div.user').style.display = 'block';
        document.querySelector('nav div.guest').style.display = 'none';
        document.querySelector('nav div.user span').textContent  = `Welcome, ${userData.email}`;
    } else {
        document.querySelector('nav div.user').style.display = 'none';
        document.querySelector('nav div.guest').style.display = 'block';
    }

    
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
};