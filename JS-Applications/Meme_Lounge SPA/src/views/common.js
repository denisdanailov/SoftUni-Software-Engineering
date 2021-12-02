import { html } from "../lib.js";

export const memeView = (meme) => html`
    <p class="meme-title">${meme.title}</p>
    <img class="meme-image" alt="meme-img" src="${meme.imageUrl}">
    </div>
    <div id="data-buttons">
        <a class="button" href="/details/${meme._id}">Details</a>
    </div>`;