
import { async} from 'regenerator-runtime';// Tworzymy funkcję loadQuiz, która przyjmuje id quizu jako argument
import {API_URL, API_URL_ALL, questionNumber, quizNumber} from './config.js'
import { getJSON } from './helpers.js';
import * as model from './model.js'
import quizView from './views/quizView.js';
import loginView from './views/loginView.js';
import registerView from './views/registerView.js';

const controlQuiz = async function(){
  try{
await model.loadQuiz(quizNumber);
quizView.render(model.state.quiz);

// quizView.goNextQuestion(questionNumber);
}
catch(err){
  console.log(err)
  // recipeView.renderError();
}
}
const controlUser = async function(){
  try{
    // await registerView._registerUser()
    // await model.getUSer()
    
  }
  catch(err){

  }
}
const controlQuestion = function(question){
   quizView.render(model.state.quiz);
}
const init = function(){
  quizView.addHandlerClick(controlQuestion)
  loginView.init();
  registerView.registerUser();
  

}
controlQuiz();
// controlUser();
init();
// _registerUser();


