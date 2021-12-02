import { html } from '../lib.js';
import { getAll } from '../api/data.js';
import { memeView } from './common.js';


const memeTemplate = (memes) => html`
<section id="meme-feed">
    <h1>All Memes</h1>
    <div id="memes">

        ${memes.length == 0
    ? html`<p class="no-memes">No memes in database.</p>`
    : html`<div class="meme">
                    <div class="card">
                        <div class="info">
                           ${memes.map(memeView)}   
                </div>`}
    </div>
</section>`;

export async function allMemesPage(ctx) {
    const memes = await getAll();

    ctx.render(memeTemplate(memes))
}