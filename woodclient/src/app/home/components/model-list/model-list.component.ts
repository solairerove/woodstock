import { Observable } from 'rxjs/Observable';
import { Component, OnInit } from '@angular/core';
import { HttpService } from './../../service/http.service';

@Component({
  selector: 'app-model-list',
  templateUrl: './model-list.component.html',
  styleUrls: ['./model-list.component.css']
})
export class ModelListComponent implements OnInit {

  public models: Observable<any>;
  private errorMessage: any;

  constructor(private httpService$: HttpService) { }

  ngOnInit() {
    this.getResponse();
  }

  getResponse() {
    this.httpService$.fetchResponse().subscribe(
      data => this.models = data,
      error => this.errorMessage = <any>error
    );
  }
}
