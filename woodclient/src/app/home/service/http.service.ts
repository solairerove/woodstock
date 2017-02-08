import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {environment} from '../../../environments/environment';

@Injectable()
export class HttpService {

  private static UNITS = '/units';

  constructor(private http$: Http) {
  }

  fetchUnits(): Observable<any> {
    return this.http$.get(environment.server + HttpService.UNITS)
      .map(HttpService.extractData)
      .catch(HttpService.handleError);
  }

  private static extractData(res: Response) {
    let data = res.json();
    return data || {};
  }

  private static handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText} || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
