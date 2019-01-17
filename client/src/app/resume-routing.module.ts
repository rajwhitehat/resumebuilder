import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ResumeComponent } from './resume/resume.component';

const routes: Routes = [
  {
    path: '', component: ResumeComponent,
  }
];

@NgModule({
  declarations: [ResumeComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [],
})
export class ResumeRoutingModule { }
