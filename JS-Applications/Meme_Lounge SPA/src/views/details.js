import { html } from '../lib.js';
import { getUserData } from '../util.js';
import { deleteMeme, getById } from '../api/data.js';

const detailsTemplate = (meme, isOwner, onDelete) => html`
    <section id="meme-details">
        <h1>Meme Title: ${meme.title}</h1>
        <div class="meme-details">
            <div class="meme-img">
                <img alt="meme-alt" src="${meme.imageUrl}">
            </div>
            <div class="meme-description">
                <h2>Meme Description</h2>
                <p> ${meme.description}</p>
    
                ${isOwner ? html`
                <a class="button warning" href="/edit/${meme._id}">Edit</a>
                <button @click=${onDelete} class="button danger">Delete</button>` : null }
            </div>
        </div>
    </section>

`;

// const memeControlsTemplate = (meme, isOwner, onDelete) => {
//     if (isOwner) {
//         return html`
//         <a class="button warning" href="/edit/${meme._id}">Edit</a>
//         <button @click=${onDelete} class="button danger">Delete</button>`
//     } else {
//         return null;
//     }
// }

export async function detailsPage(ctx) {
    const userData = getUserData();

    const meme = await getById(ctx.params.id);

    const isOwner = userData && userData.id == meme._ownerId;

    ctx.render(detailsTemplate(meme, isOwner, onDelete));

    async function onDelete() { 
        const choice = confirm('Are you sure you want to delete this meme FOREVER?');
       
        if (choice) {
            await deleteMeme(ctx.params.id);
            ctx.page.redirect('/all-memes')
        }
    }
}