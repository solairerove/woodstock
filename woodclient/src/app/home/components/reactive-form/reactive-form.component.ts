import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  form: FormGroup;

  firstName = new FormControl('', Validators.required);

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      'firstName': this.firstName,
      'password': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.form);
    console.log(this.form.value);
  }
}
