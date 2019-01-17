import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [ 
  { path: '', component: HomepageComponent },
  { path: 'resume', loadChildren: './resume-routing.module#ResumeRoutingModule' },
  { path: 'quiz', loadChildren: './quiz-routing.module#QuizRoutingModule' }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
