
import { API_ULR_LOGIN_PASSWORD, API_URL, API_URL_LOGIN_EMAIL,API_URL_ALL, API_URL_USERS } from './config.js';
import { getJSON } from './helpers.js';

export const state = { 
    quiz:{},
    userData : {
      username: '',
      email: '',
      password: ''
    },
 }



  export const createUser = async function(userData) {
  try {
      const { username, password, email } = userData;
      const userDataToSend = { username, password, email };
      const response = await fetch(`${API_URL}${API_URL_USERS}`, {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(userDataToSend)
      });

      if (!response.ok) {
          throw new Error('Błąd podczas tworzenia użytkownika');
      }
      const responseDataText = await response.text();
      console.log('Odpowiedź z serwera:', responseDataText);

      const responseData = await response.json();
      console.log('Nowy użytkownik został utworzony:', responseData);

      return responseData; 
  } catch (error) {
      console.error('Błąd:', error);
      throw error; 
  }
};
export const loadUser = async function(email,passowrd){
    try{
        const user = await getJSON(`${API_URL}${API_URL_USERS}${API_URL_LOGIN_EMAIL}${email}${API_ULR_LOGIN_PASSWORD}${passowrd}`)
        state.userData = {
            email: user.email,
            username: user.username,
            passoword: user.passoword

        } 
        console.log('zalogowano pomyślnie');
      
    }
    catch(err){
        console.log('Użytkownik z takim adresem E-mail i hasłem nie istnieje');
    }
}
    



  export const loadQuiz = async function(quizId) {
  
    try{
      const quiz = await getJSON(`${API_URL}${API_URL_ALL}/${quizId}`)
      state.quiz = {
                    id: quiz.id, // ID quizu
                    name: quiz.name, // Nazwa quizu
                    questions: quiz.questions.map(question => ({ // Tablica pytań
                        id: question.id, // ID pytania
                        question: question.question, // Treść pytania
                        answers: question.answers.map(answer => ({ // Tablica odpowiedzi
                          id: answer.id, // ID odpowiedzi
                          answer: answer.answer, // Treść odpowiedzi
                          true: answer.true // Czy odpowiedź jest poprawna
                        }))   
                    }))
                };
      console.log(state.quiz);
  }
  catch(err){
      console.log(`${err} bruhbruhbruh`);
      throw err;
  }
  }
