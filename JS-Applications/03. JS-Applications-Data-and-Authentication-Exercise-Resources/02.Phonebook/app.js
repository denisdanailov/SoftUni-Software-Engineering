function attachEvents() {
    
    document.getElementById('btnLoad').addEventListener('click', loadContacts);
    document.getElementById('btnCreate').addEventListener('click', onCreate);

    const list = document.getElementById('phonebook');

    list.addEventListener('click', onDelete);
}

attachEvents();

const url = 'http://localhost:3030/jsonstore/phonebook/';
const list = document.getElementById('phonebook');
const personIput = document.getElementById('person');
const phoneInput = document.getElementById('phone');

function createItem(contact) {
    const liElement = document.createElement('li');
    liElement.innerHTML = `${contact.person}: ${contact.phone} <button data-id="${contact._id}"">Delete</button>`;

    return liElement;
}

async function onDelete(event) {
    const id = event.target.dataset.id;

    if (id != undefined) {
        await deleteContact(id);
        event.target.parentElement.remove();
    }

}

async function onCreate() {
        const person = personIput.value;
        const phone = phoneInput.value;
        const contact = {person, phone};

        await createContact(contact);

        list.appendChild(createItem(contact));
}

async function loadContacts() {

    const response = await fetch(url);
    const data = await response.json();
    list.replaceChildren();
    Object.values(data).map(createItem).forEach(i => list.appendChild(i));
}

async function createContact(contact) {

    const response = await fetch(url , {
        method: 'post',
        headers: {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(contact)
    });
    const result = await response.json();

    return result;

}

async function deleteContact(id) {
    const response = await fetch(url + id, {
        method: 'delete'
    });

    const result = await response.json();
    
    return result;
}