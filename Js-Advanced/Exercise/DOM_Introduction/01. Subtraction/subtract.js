function subtract() {

    const result = document.getElementsByName('result');
    const first = Number(document.getElementById('firstNumber').value);
    const second = Number( document.getElementById('secondNumber').value);
    
    
    document.getElementById('result').textContent = first - second;
    
}