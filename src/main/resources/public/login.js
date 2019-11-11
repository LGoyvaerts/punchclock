const URL = 'http://localhost:8081';

const signUp = (e) => {
    const fromData = new FormData(e.target);
    const credentials = {};
    credentials['username'] = fromData.get('signUpUsername');
    credentials['password'] = fromData.get('signUpPassword');

    console.log('Before fetch');
    fetch(`${URL}/users/signup`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    }).then((result) => {
        console.log('Result: ' + result);
        result.json().then((user) => {
            window.location.href = `${URL}/`;
            return false;
        })
    });
};

const login = (e) => {
    const fromData = new FormData(e.target);
    const credentials = {};
    credentials['username'] = fromData.get('loginUsername');
    credentials['password'] = fromData.get('loginPassword');

    console.log('Before fetch');
    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    }).then((result) => {
        console.log('Result: ' + result);
        result.json().then((user) => {
            window.location.href = `${URL}/`;
            return false;
        })
    });
};

document.addEventListener('DOMContentLoaded', function () {
    const signUpForm = document.querySelector('#signUpForm');
    const loginForm = document.querySelector('#loginForm');
    signUpForm.addEventListener('submit', signUp);
    loginForm.addEventListener('submit', login);
});