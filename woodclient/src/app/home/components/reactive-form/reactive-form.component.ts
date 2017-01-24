import {Component, OnInit} from '@angular/core';
import {FormGroup, Validators, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      'firstName': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  onSubmit() {
    console.log(this.form.value);
  }

  fullUpdate() {
    this.form.patchValue({firstName: 'Space', password: 'Monlkey'});
  }

  partialUpdate() {
    this.form.patchValue({firstName: 'Space'});
  }

  reset() {
    this.form.reset();
  }
}
