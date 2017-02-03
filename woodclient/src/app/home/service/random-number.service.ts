import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';

@Injectable()
export class RandomNumberService {

    pick() {
        return Observable.of(Math.floor(Math.random() * 100));
    }
}
