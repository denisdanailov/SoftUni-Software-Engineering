import { getById, deleteGame, createComment , getCommentById} from "../api/data.js";
import { html } from "../lib.js";
import { getUserData } from "../util.js";
import { nothing } from "../../node_modules/lit-html/lit-html.js";
import { commentView } from "../views/common.js";

const detailsTemplate = (game, isOwner, onDelete, comments, isLogged, onPost) => html`
<section id="game-details">
    <h1>Game Details</h1>
    <div class="info-section">

        <div class="game-header">
            <img class="game-img" src="${game.imageUrl}" />
            <h1>${game.title}</h1>
            <span class="levels">${game.maxLevel}</span>
            <p class="type">${game.category}</p>
        </div>

        <p class="text">
            ${game.summary}
        </p>

        ${isOwner ? html`<div class="buttons">
            <a href="/edit/${game._id}" class="button">Edit</a>
            <a href="javascript:void(0)" @click=${onDelete} class="button">Delete</a>
        </div>` : nothing}

        ${isLogged && !isOwner ? html` <article class="create-comment">
            <label>Add new comment:</label>
            <form @submit=${onPost} class="form">
                <textarea name="comment" placeholder="Comment......"></textarea>
                <input class="btn submit" type="submit" value="Add Comment">
            </form>
        </article>` : nothing}

        <div class="details-comments">
            <h2>Comments:</h2>
            <ul>
                ${comments.length == 0 ? html`<p class="no-comment">No comments.</p>`
        : html` ${comments.map(commentView)}`}
            </ul>
        
           
`;

export async function detailsPage(ctx) {
    const userData = getUserData();

    const game = await getById(ctx.params.id);

    const comments = await getCommentById(ctx.params.id);

    const isOwner = userData && userData.id == game._ownerId;

    const isLogged = userData != null;

    ctx.render(detailsTemplate(game, isOwner, onDelete, comments, isLogged, onPost));

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete this game?!');

        if (choice) {
            await deleteGame(ctx.params.id);
            ctx.page.redirect('/catalog')
        }
    }
    
    async function onPost(event) {
        event.preventDefault();
        const formData = new FormData(event.target);

        const gameId = ctx.params.id;
        const comm = formData.get('comment');

        if (comm == '') {
            alert('Please fill comment field!');
        }
      
        await createComment(gameId, comm);
        ctx.updateUserNav();
        ctx.page.redirect('/details/' + ctx.params.id);
    }
}


