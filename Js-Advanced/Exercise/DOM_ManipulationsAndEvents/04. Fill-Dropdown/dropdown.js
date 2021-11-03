function addItem() {
    
    const text = document.getElementById('newItemText');
    const val = document.getElementById('newItemValue');

    const select = document.getElementById('menu');
    const option = document.createElement("option");

    option.value = val.value;
    option.textContent = text.value;
    select.appendChild(option);
    
    text.value = '';
    val.value = '';
}