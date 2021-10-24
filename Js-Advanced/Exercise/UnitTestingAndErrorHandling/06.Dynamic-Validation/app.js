function validate() {
    const inputField = document.getElementById('email');

    const emailPattern = /^[a-z]+@[a-z]+\.[a-z]+$/;

    inputField.addEventListener('change',() => {
        if (!emailPattern.test(inputField.value)) {
            inputField.classList.add('error')
        } else {
            inputField.classList.remove('error');
        }
    })
}