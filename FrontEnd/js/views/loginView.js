import View from './View.js';
import * as model from '../model.js'

const LoginView = {
    init(){
        const loginBtn = document.getElementById('loginBtn');
        const loginPopup = document.getElementById('loginPopup');
        const closeBtn = document.querySelector('.close');
        const loginForm = document.getElementById('loginForm');
        const registerBtn = document.querySelector('.register');
        if (!loginBtn) return;


        loginBtn.addEventListener('click', () => {
            loginPopup.style.display = 'block';
            registerPopup.style.display ='none';
        });

        closeBtn.addEventListener('click', () => {
            loginPopup.style.display = 'none';
        });

        registerBtn.addEventListener('click', () => {
            loginPopup.style.display = 'none';
          
        });

        window.addEventListener('click', (e) => {
            if (e.target === loginPopup) {
                loginPopup.style.display = 'none';
            }
        });

        loginForm.addEventListener('submit', (e) => {
            e.preventDefault(); 

            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            console.log('Email:', email);
            console.log('Password:', password);
            
            model.loadUser(email,password);
            
            // Wyczyszczenie pól
            document.getElementById('email').value = '';
            document.getElementById('password').value = '';


            // Zamknięcie popup po logowaniu
            loginPopup.style.display = 'none';
        });
    }
};

export default LoginView;