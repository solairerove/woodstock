/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FirstDumbComponent } from './first-dumb.component';

describe('FirstDumbComponent', () => {
  let component: FirstDumbComponent;
  let fixture: ComponentFixture<FirstDumbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstDumbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
