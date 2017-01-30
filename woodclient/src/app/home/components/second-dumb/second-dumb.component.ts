import { Component, OnInit, Injector } from '@angular/core';

@Component({
  selector: 'app-second-dumb',
  templateUrl: './second-dumb.component.html',
  styleUrls: ['./second-dumb.component.css']
})
export class SecondDumbComponent implements OnInit {

  showNum = 0;

  constructor(private injector: Injector) {
    this.showNum = this.injector.get('showNum');
  }

  ngOnInit() {
  }

}
