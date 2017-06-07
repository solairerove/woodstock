import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { AnswerMySuffix } from './answer-my-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class AnswerMySuffixService {

    private resourceUrl = 'api/answers';

    constructor(private http: Http) { }

    create(answer: AnswerMySuffix): Observable<AnswerMySuffix> {
        const copy = this.convert(answer);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(answer: AnswerMySuffix): Observable<AnswerMySuffix> {
        const copy = this.convert(answer);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<AnswerMySuffix> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            return res.json();
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convert(answer: AnswerMySuffix): AnswerMySuffix {
        const copy: AnswerMySuffix = Object.assign({}, answer);
        return copy;
    }
}
