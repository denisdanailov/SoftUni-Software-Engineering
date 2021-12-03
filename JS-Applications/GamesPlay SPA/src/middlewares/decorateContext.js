import { logout } from '../api/api.js';
import { page ,render  } from '../lib.js';
import { getUserData } from '../util.js'

const root = document.getElementById('main-content');
document.getElementById('logoutBtn').addEventListener('click',onLogout);

export default function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    
    next();
};

export function updateUserNav() {
    const userData = getUserData();

    if (userData) {
        document.getElementById ('user').style.display = 'block';
        document.getElementById('guest').style.display = 'none';
        // document.getElementById('welcome').textContent = `Welcome, ${userData.username}`;
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'block';
    }

    
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
};