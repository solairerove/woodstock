import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { AnswerMySuffixDetailComponent } from '../../../../../../main/webapp/app/components/answer/answer-my-suffix-detail.component';
import { AnswerMySuffixService } from '../../../../../../main/webapp/app/components/answer/answer-my-suffix.service';
import { AnswerMySuffix } from '../../../../../../main/webapp/app/components/answer/answer-my-suffix.model';

describe('Component Tests', () => {

    describe('AnswerMySuffix Management Detail Component', () => {
        let comp: AnswerMySuffixDetailComponent;
        let fixture: ComponentFixture<AnswerMySuffixDetailComponent>;
        let service: AnswerMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [AnswerMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    AnswerMySuffixService,
                    EventManager
                ]
            }).overrideComponent(AnswerMySuffixDetailComponent, {
                set: {
                    template: ''
                }
            }).compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(AnswerMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AnswerMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new AnswerMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.answer).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
