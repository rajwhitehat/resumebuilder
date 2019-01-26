import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
  providers: [QuizService]
})
export class QuizComponent implements OnInit {
subjectList: any =[];
  constructor(private quizService: QuizService) { }

  ngOnInit() {
    this.quizService.getAllSubjects().subscribe((res: any) => {
this.subjectList = res;
    }, error =>{
      console.log(error);
    });
  }

 
}
