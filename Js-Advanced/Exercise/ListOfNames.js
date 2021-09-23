function slove(input) {

   let arr = input.sort((a, b) => a.localeCompare(b));

   let count = 1;

   return arr.forEach(element => {
        console.log(`${count}.${element}`);
        count++;
    }); 
}

slove(
["John", "Bob", "Christina", "Ema"]
);