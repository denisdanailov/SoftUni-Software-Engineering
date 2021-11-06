async function loadCommits() {
    const html = {
        nameField: document.getElementById('username'),
        repoField: document.getElementById('repo'),
        commits: document.getElementById('commits')

    }

    html.commits.innerHtml = '';

    const createFunc = (tag, content = '') => {
        const element = document.createElement(tag);
        element.innerHTML = content;

        return element;
    }

    try {

        url = `https://api.github.com/repos/${html.nameField.value}/${html.repoField.value}/commits`;

        const data = await fetch(url);

        if (!data.ok) {
            throw new Error(`${data.status} (${data.statusText})`);
        }

        const deserialized = await data.json();

        html.commits.replaceChildren();

        deserialized.forEach(({ commit }) => html.commits.appendChild(createFunc(
            'li',
            `${commit.author.name}: ${commit.message}`
        )));

    } catch (error) {
        html.commits.appendChild(createFunc('li', error));
    }

}