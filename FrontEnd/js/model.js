
import { async} from 'regenerator-runtime';// Tworzymy funkcję loadQuiz, która przyjmuje id quizu jako argument
import {API_URL, API_URL_ALL, quizNumber} from './config.js'
import { getJSON } from './helpers.js';
export const state = { 
    quiz:{},

  
  }
//   export const getNextQuestion(){

//   }

  // Użyj funkcji fetch do wysłania zapytania GET do twojego API
  export const loadQuiz = async function(quizId) {
  
    try{
      const quiz = await getJSON(`${API_URL}${API_URL_ALL}/${quizId}`)
  
      // const {quiz} = data;
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
      // console.log(data);
      // console.log(data);
  
  }
  
  catch(err){
      console.log(`${err} bruhbruhbruh`);
      throw err;
  }
  }
