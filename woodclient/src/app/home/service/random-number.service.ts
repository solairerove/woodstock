import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';

@Injectable()
export class RandomNumberService {

    pick() {
        return Math.floor(Math.random() * 100);
    }
}
