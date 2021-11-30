import { html } from "../../lib.js";
import { searchBook } from "../api/data.js";
import { bookPreview } from "./common.js";

const searchTemplate = (books, onSearch, params = '') => html`
    <section id="dashboard-page" class="dashboard">
        <h1>Search</h1>
    
        <form @sumbit=${onSearch} id="search">
            <input type="text" name="serch" .value=${params}>
            <input type="submit" value="search" id="searchBtn">
        </form>
    
        ${books.length == 0
        ? html`<p class="no-books">No results!</p>`
        : html`<ul class="other-books-list"> ${books.map(bookPreview)} </ul>`}
    
    </section>
`;

export async function searchPage(ctx) {
    const params = ctx.querystring.split('=')[1];
    let books = [];

    if(params) {
       books = await searchBook(decodeURIComponent(params));
    }

    ctx.render(searchTemplate(books, onSearch, params));

    function onSearch(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const search = formData.get('search');

        if (search) {
            ctx.page.redirect('/search?query=' + encodeURIComponent(search));
        }
    }
}