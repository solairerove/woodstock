import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { QuestionMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/question/question-my-suffix-detail.component';
import { QuestionMySuffixService } from '../../../../../../main/webapp/app/entities/question/question-my-suffix.service';
import { QuestionMySuffix } from '../../../../../../main/webapp/app/entities/question/question-my-suffix.model';

describe('Component Tests', () => {

    describe('QuestionMySuffix Management Detail Component', () => {
        let comp: QuestionMySuffixDetailComponent;
        let fixture: ComponentFixture<QuestionMySuffixDetailComponent>;
        let service: QuestionMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [QuestionMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    QuestionMySuffixService,
                    EventManager
                ]
            }).overrideComponent(QuestionMySuffixDetailComponent, {
                set: {
                    template: ''
                }
            }).compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(QuestionMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(QuestionMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new QuestionMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.question).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
