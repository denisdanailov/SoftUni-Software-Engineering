function printRandNum() {

    const digit = 1;

    let num = Math.round(
    
    Math.random() * 100);
    
    document.body.innerHTML +=
    
    `<div>${num}</div>`;
    
    }