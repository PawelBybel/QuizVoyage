import View from './View.js';
import { questionNumber } from '../config.js';
import * as model from '../model.js'

class QuizView extends View {
    _parentElement = document.querySelector('.question-button');
     number = questionNumber;
  
    addHandlerClick(handler) {
        this._parentElement.addEventListener('click', function(e) {
            const btn = e.target.closest('.answer1');
            if (!btn) return;
            const nextQuestion = +btn.dataset.goto;
            const isCorrect = btn.dataset.isCorrect === 'true';
            if (isCorrect) {
                btn.style.backgroundColor = 'green'; // Ustawienie koloru na zielony dla prawidłowej odpowiedzi
            }
            else {
                    btn.style.backgroundColor = 'red'; // Ustawienie koloru na zielony dla prawidłowej odpowiedzi
                
            }
            console.log(isCorrect); // Sprawdzenie wartości atrybutu data-is-correct
            // this.number++;
            setTimeout(() => {
                handler(nextQuestion);
            }, 2000); // 5000 milisekund = 5 sekund
            });
    }
 
    
    _generateMarkupPreview(quiz) {
        const question = quiz.questions[this.number];
        console.log(this.number);
        this.number++;
        if (this.number <= quiz.questions.length) {
        const answersMarkup = question.answers.map((answer, index) => `
            <button class="answer1" data-answer-index="${index}" data-is-correct="${answer.true ? 'true' : 'false'}">${answer.answer}</button>
        `).join('');
        
        return `
            <div class="question">${question.question}</div>
            ${answersMarkup}
        `;
        }
        else{ return `
        <div class="question">To było ostatnie pytanie</div>
        
    `;

        }
        
    }
}

export default new QuizView();