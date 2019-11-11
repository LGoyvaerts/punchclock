document.addEventListener('DOMContentLoaded', function(){
    const signUpForm = document.querySelector('#signUpForm');
    const loginForm = document.querySelector('#loginForm');
    signUpForm.addEventListener('submit', () => {});
    loginForm.addEventListener('submit', () => {});
});

const signUp = (e) => {
    const fromData = new FormData(e.target);
};