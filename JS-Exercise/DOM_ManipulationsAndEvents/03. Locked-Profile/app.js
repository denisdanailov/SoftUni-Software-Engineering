function lockedProfile() {


    Array.from(document.querySelectorAll('.profile button'))
        .forEach(b => b.addEventListener('click', onToggle));


    function onToggle(e) {
        const profile = e.target.parentElement;
        const isActive = profile.querySelector('input[type="radio"][value="unlock"]').checked;


        if (isActive) {
            const infoDif = profile.querySelector('div');

            if (e.target.textContent == 'Show more') {
                infoDif.style.display = 'block'
                e.target.textContent = 'Hide it';
            } else {
                infoDif.style.display = '';
                e.target.textContent = 'Show more';
            }
        }

    }
}

const radio = Array.from(document.querySelectorAll('input[type="radio"]'));
for (let input of radio) {
    input.addEventListener('click', onLockToggle);

}

function onLockToggle(e) {
    const button = e.target.parentElement.querySelector('button');

    if (e.target.value == 'lock') {
        button.disabled = true;
    } else {
        button.disabled = false;
    }
}