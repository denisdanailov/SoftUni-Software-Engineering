import {html, render} from './node_modules/lit-html/lit-html.js';
import { towns } from './towns.js';

const listTemplate = (cityes) => html`
 <ul>
       ${cityes.map(c => html`<li class=${c.match ? 'active' : '' }>${c.name}</li>`)}
   </ul>`;

   const cityes = towns.map(c => ({name: c, match: false}));
   const root = document.getElementById('towns');
   const input = document.getElementById('searchText');
   const output = document.getElementById('result');
   document.querySelector('button').addEventListener('click', onSearch);

   update();

   function update() {
      
      render(listTemplate(cityes), root);
   }

   function onSearch() {
      const match = input.value.trim().toLocaleLowerCase();
      let count = 0;

      for (let city of cityes) {
         if (match && city.name.toLocaleLowerCase().includes(match)) {
            city.match = true;
            count++;
         } else {
            city.match = false;
         }
      }
     
      output.textContent = `${count} matches found`;
      update();
   }

