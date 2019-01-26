import { Injectable } from '@angular/core';
import { Response, Headers, RequestOptions } from "@angular/http";
import { Observable } from "rxjs/Observable";
import { HttpClient } from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {BASE_PATH, BASE_URL} from "../config/api.config";


@Injectable()
export class BaseService{

  constructor(private http: HttpClient) { }

getData(url: any): Observable<any>{
return this.http.get(BASE_URL+BASE_PATH+url);
}
  
}
