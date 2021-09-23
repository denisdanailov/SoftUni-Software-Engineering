function checkSameNumbers(number) {

let str = String(number);
let isEqual = true
let sum = 0;
for (let index = 0; index <= str.length - 1; index++) {
    
    let equalNum = str.charAt(0);
    if (str.charAt(index) !== equalNum) {
        isEqual = false;
    }
    sum += Number(str.charAt(index));
}

console.log(isEqual);
console.log(sum);
  
}

checkSameNumbers();