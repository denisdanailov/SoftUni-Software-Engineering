function search() {
  
   const arr = Array.from(document.querySelectorAll("ul li"));
   const input = document.getElementById("searchText").value;
   const result = document.getElementById("result");

   let counter = 0;
   arr.forEach(e => {
    
      if (e.textContent.includes(input)) {
         e.style.fontWeight = "bold";
         e.style.textDecoration = "underline";
         counter++;
         
      } else {
         e.style.fontWeight = "normal";
         e.style.textDecoration = "";
      }
   });
   result.textContent = `${counter} matches found`;
}
