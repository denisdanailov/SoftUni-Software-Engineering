
const loadBtn = document.getElementById('load');
const submitBtn = document.getElementById('submit');
// const table = document.getElementById('results');
const url = 'http://localhost:3030/jsonstore/collections/students';



function createItem(contact) {
    const trElement = document.createElement('tr');
    trElement.innerHTML = `${contact.firstName} ${contact.lastName}  ${contact.grade}  ${contact._id} `;

    return trElement;
}


function displayStudents (studentsData) {
		const table = document.querySelector('#results > tbody')
		table.innerHTML = ''
	
		Object.values(studentsData).forEach(student => {
			const tr = document.createElement('tr')
	
			Object.entries(student).forEach(([key, value]) => {
				const td = document.createElement('td')
	
				if (key !== '_id') {
					td.innerHTML = value
					tr.appendChild(td)
				}
			})
	
			table.appendChild(tr)
		})
	
	}
	

loadBtn.addEventListener('click',  displayStudents);
// 	// const respone = await fetch (url);
// 	// const data = await respone.json();
// 	// table.replaceChildren();

// 	const trElement = document.createElement('tr');

//     trElement.innerHTML = 'Denis';
// 	table.innerHTML = '';
// 	table.appendChild(trElement);

// 	// Object.values(data).map(createItem).forEach(i => table.appendChild(i));
// })

// const response = await fetch(url);
// const data = await response.json();
// list.replaceChildren();
// Object.values(data).map(createItem).forEach(i => list.appendChild(i));

// async function getStudents(data) {

// 	const respone = await fetch('url');

// 	return await respone.json();
// }

// async function postStudents(data) {

// 	const respone = await fetch(url , {
// 		method: 'post',
// 		headers: {'Content-type': 'application/json'},
// 		body: JSON.stringify(data)
// 	});
	





// const clearFields = (arr) => arr.forEach(x => x.value = '')

// function validData (data) {
// 	return data.every(([_, value]) => value !== '')
// }

// function displayStudents (studentsData) {
// 	const table = document.querySelector('#results > tbody')
// 	table.innerHTML = ''

// 	Object.values(studentsData).forEach(student => {
// 		const tr = document.createElement('tr')

// 		Object.entries(student).forEach(([key, value]) => {
// 			const td = document.createElement('td')

// 			if (key !== '_id') {
// 				td.innerHTML = value
// 				tr.appendChild(td)
// 			}
// 		})

// 		table.appendChild(tr)
// 	})

// }

// async function getStudents () {
// 	const response = await fetch('http://localhost:3030/jsonstore/collections/students')

// 	return await response.json()
// }

// async function postStudent (data) {
// 	const response = await fetch('http://localhost:3030/jsonstore/collections/students', {
// 		method: 'post',
// 		headers: { 'content-type': 'application/json' },
// 		body: JSON.stringify(Object.fromEntries(data))
// 	})

// 	return await response.json()
// }

// document.addEventListener('submit', async (e) => {
// 	e.preventDefault()
// 	const formData = new FormData(e.target)
// 	const data = [...formData.entries()]

// 	if (validData(data)) {
// 		await postStudent(data)
// 		displayStudents(await getStudents())
// 		clearFields([...document.querySelectorAll('#form > div.inputs > input[type=text]')])
// 	}
// })