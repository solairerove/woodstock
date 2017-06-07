import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ChapterMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/chapter/chapter-my-suffix-detail.component';
import { ChapterMySuffixService } from '../../../../../../main/webapp/app/entities/chapter/chapter-my-suffix.service';
import { ChapterMySuffix } from '../../../../../../main/webapp/app/entities/chapter/chapter-my-suffix.model';

describe('Component Tests', () => {

    describe('ChapterMySuffix Management Detail Component', () => {
        let comp: ChapterMySuffixDetailComponent;
        let fixture: ComponentFixture<ChapterMySuffixDetailComponent>;
        let service: ChapterMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [ChapterMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ChapterMySuffixService,
                    EventManager
                ]
            }).overrideTemplate(ChapterMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ChapterMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ChapterMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ChapterMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.chapter).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
