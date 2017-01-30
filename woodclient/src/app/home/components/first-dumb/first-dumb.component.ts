import { Component, OnInit, Injector } from '@angular/core';

@Component({
  selector: 'app-first-dumb',
  templateUrl: './first-dumb.component.html',
  styleUrls: ['./first-dumb.component.css']
})
export class FirstDumbComponent implements OnInit {

  showNum = 0;

  constructor(private injector: Injector) {
    this.showNum = this.injector.get('showNum');
  }

  ngOnInit() {
  }

}
