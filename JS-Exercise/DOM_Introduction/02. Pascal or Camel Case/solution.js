function solve() {
  const text = document.getElementById("text").value.toLowerCase();

  const naming = document.getElementById('naming-convention').value;

  const resultContainer = document.getElementById("result");

  const splitted = text.split(" ");

  let textConvert = '';

 if (naming == "Pascal Case") {
   
   for(let i = 0; i < splitted.length; i++) {
       textConvert += splitted[i][0].toUpperCase()+ splitted[i].slice(1, splitted[i].length);
   }
  resultContainer.textContent = textConvert;

 } else if (naming == "Camel Case") {
    textConvert += splitted[0][0].toLowerCase() + splitted[0].slice(1,splitted[0].length);

    for(let i = 1; i < splitted.length ; i++) {
      textConvert += splitted[i][0].toUpperCase()+ splitted[i].slice(1, splitted[i].length);
  }

  resultContainer.textContent = textConvert;


 } else {
   resultContainer.textContent = "Error!";
 }
}