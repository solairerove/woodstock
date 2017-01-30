/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { SecondDumbComponent } from './second-dumb.component';

describe('SecondDumbComponent', () => {
  let component: SecondDumbComponent;
  let fixture: ComponentFixture<SecondDumbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecondDumbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
