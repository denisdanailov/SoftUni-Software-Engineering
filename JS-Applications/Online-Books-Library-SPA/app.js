import { page } from './lib.js';
import decorateContext, { updateUserNav } from './src/middlewares/decorateContext.js';
import { createPage } from './src/views/create.js';
import { detailsPage } from './src/views/details.js';
import { editPage } from './src/views/edit.js';
import { homePage } from './src/views/home.js';
import { loginPage } from './src/views/login.js';
import { myBooksPage } from './src/views/my-books.js';
import { registerPage } from './src/views/register.js';
import { searchPage } from './src/views/search.js';



page(decorateContext);
page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/my-books', myBooksPage);
page('/search', searchPage);

updateUserNav();
page.start();

