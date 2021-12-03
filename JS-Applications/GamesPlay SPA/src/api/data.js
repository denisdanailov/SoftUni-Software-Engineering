import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

const endpoints = {
    all: '/data/games?sortBy=_createdOn%20desc',
    byId: '/data/games/',
    latestGames: '/data/games?sortBy=_createdOn%20desc&distinct=category',
    create: '/data/games',
    edit: '/data/games/',
    delete: '/data/games/',
    // getCommById: (gameId) => ``,
    createComm: '/data/comments'
    // search: (year) => `/data/cars?where=year%3D${year}`
}

export async function getAll() {
    return api.get(endpoints.all);
}

export async function getById(id) {
    return api.get(endpoints.byId + id);
}

export async function latestGames() {
    return api.get(endpoints.latestGames);
    
}

export async function create(meme) {
    return api.post(endpoints.create, meme);
}

export async function editItem(id, data) {
    return api.put(endpoints.edit + id, data)
}

export async function deleteGame(id) {
    return api.del(endpoints.delete + id)
}

export async function likeBook(bookId) {
    return api.post('/data/likes', {
        bookId
    });
}

export async function getLikesByBookId(bookId) {
    return api.get(`/data/likes?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`)
}

export async function getMyLikeByBookId(bookId, userId) {
    return api.get(`/data/likes?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`)
}

// export async function searchCar(query) {
//     return api.get(endpoints.search(query));
// }

export async function getCommentById(gameId) {
    return api.get(`/data/comments?where=gameId%3D%22${gameId}%22`);
}

export async function createComment(gameId, comment) {
    return api.post(endpoints.createComm, {
        gameId,
        comment
    });
}

