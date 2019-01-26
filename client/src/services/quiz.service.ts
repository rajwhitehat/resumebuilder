import {map} from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs';
import { BaseService } from './base-service';

@Injectable()
export class QuizService extends BaseService {


    getAllSubjects(): Observable<any> {
        return this.getData('/getSubject').pipe(
          map((res: Response) => {
            return res;
          }));
      }
}