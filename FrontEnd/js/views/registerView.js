import View from './View.js';
import * as model from '../model.js'

const registerView = {
    registerUser() {
        
        const registerBtn = document.getElementById('registerBtn');
        const registerPopup = document.getElementById('registerPopup');
        const closeBtn = document.querySelector('#registerPopup .close');
        const registerForm = document.getElementById('registerForm');
       
        if (!registerBtn) return;
        
   
        registerBtn.addEventListener('click', () => {
            registerPopup.style.display = 'block';
        });

        closeBtn.addEventListener('click', () => {
            registerPopup.style.display = 'none';
        });

        window.addEventListener('click', (e) => {
            if (e.target === registerPopup) {
                registerPopup.style.display = 'none';
            }
        });

        registerForm.addEventListener('submit', async (e) => {
            e.preventDefault(); 
            console.log("1234");
            const username = document.getElementById('username2').value;
            const password = document.getElementById('password2').value;
            const email = document.getElementById('email2').value;
            model.state.userData.password = password;
            model.state.userData.email = email;
            model.state.userData.username = username;


         
                
                // Wyczyszczenie pól formularza po rejestracji
                document.getElementById('username2').value = '';
                document.getElementById('password2').value = '';
                document.getElementById('email2').value = '';
                model.createUser(model.state.userData)
                
        });
    }
};

export default registerView;