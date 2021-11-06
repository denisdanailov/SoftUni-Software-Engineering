async function loadRepos() {
   
   const url = 'https://api.github.com/users/testnakov/repos'

   const response = await fetch(url);
   const data = await response.json();

   console.log(data);

   const divElement = document.getElementById('res');

   const liElement = document.createElement('li');

   const list = document.getElementById('res');

   liElement.innerHTML = Object.entries(...data);

   list.appendChild(liElement);
}