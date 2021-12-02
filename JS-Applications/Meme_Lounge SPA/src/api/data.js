import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

const endpoints = {
    all: '/data/memes?sortBy=_createdOn%20desc',
    byId: '/data/memes/',
    userMemes: (userId) => `/data/memes?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`,
    create: '/data/memes',
    edit: '/data/memes/',
    delete: '/data/memes/',
    search: (query) => '/data/books/?where=' + encodeURIComponent(`title LIKE "${query}"`)
}

export async function getAll() {
    return api.get(endpoints.all);
}

export async function getById(id) {
    return api.get(endpoints.byId + id);
}

export async function userProfile(userId) {
    return api.get(endpoints.userMemes(userId));
    
}

export async function createMeme(meme) {
    return api.post(endpoints.create, meme);
}

export async function editItem(id, data) {
    return api.put(endpoints.edit + id, data)
}

export async function deleteMeme(id) {
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

export async function searchBook(query) {
    return api.get(endpoints.search(query));
}

