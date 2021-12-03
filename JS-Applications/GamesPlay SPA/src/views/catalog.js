import { getAll } from "../api/data.js";
import { html } from "../lib.js";
import { getUserData } from "../util.js";
import { catalogGameView } from "./common.js";

const catalogTemplate = (games) => html`
 <section id="catalog-page">
            <h1>All Games</h1>
            
        ${games.length == 0 ? html`<h3 class="no-articles">No articles yet</h3>`
            : html`${games.map(catalogGameView)}`}

        </section>`;


export async function catalogPage(ctx) {

    const userData = getUserData();

    const games = await getAll();
    ctx.render(catalogTemplate(games));
}
