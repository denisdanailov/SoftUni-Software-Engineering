import * as api from '../api/api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

const endpoints = {
    all: '/data/books?sortBy=_createdOn%20desc',
    byId: '/data/books/',
    myBooks: (userId) => `/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`,
    create: '/data/books',
    edit: '/data/books/',
    delete: '/data/books/',
    search: (query) => '/data/books/?where=' + encodeURIComponent(`title LIKE "${query}"`)
}

export async function getAll() {
    return api.get(endpoints.all);
}

export async function getById(id) {
    return api.get(endpoints.byId + id);
}

export async function getMyBooks(userId) {
    return api.get(endpoints.myBooks(userId));
    
}

export async function createBook(book) {
    return api.post(endpoints.create, book);
}

export async function editItem(id, data) {
    return api.put(endpoints.edit + id, data)
}

export async function deleteBook(id) {
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