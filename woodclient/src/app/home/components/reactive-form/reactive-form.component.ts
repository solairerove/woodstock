import {Component, OnInit} from '@angular/core';
import {FormGroup, Validators, FormBuilder, FormControl} from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  firstName: FormControl;
  password: FormControl;

  form: FormGroup;

  constructor(private builder: FormBuilder) {
  }

  ngOnInit() {
    this.initField();

    this.form = this.builder.group({
      'firstName': this.firstName,
      'password': this.password
    });
  }

  private initField() {
    this.firstName = new FormControl('', [
      Validators.required,
      Validators.minLength(5)
    ]);
    this.password = new FormControl('', [
      Validators.required,
      Validators.minLength(5)
    ]);
  }

  onSubmit() {
    console.log(this.form.value);
  }

  fullUpdate() {
    this.form.patchValue({firstName: 'Space', password: 'Monkey'});
  }

  partialUpdate() {
    this.form.patchValue({firstName: 'Space'});
  }

  reset() {
    this.form.reset();
  }
}
