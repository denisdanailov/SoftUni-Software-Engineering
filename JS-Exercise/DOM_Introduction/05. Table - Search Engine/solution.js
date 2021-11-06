function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
     
      const data = Array.from(document.querySelectorAll("tbody tr"));
      
      const input = document.getElementById("searchField");
      const inputToLow = input.value.toLowerCase();

      data.forEach((e) => {
         let text = e.textContent.toLowerCase();
         if (text.includes(inputToLow)) {
            e.classList.add("select");
         } else {
            e.classList.remove("select")
         }
      })

      input.value = "";

   }
}