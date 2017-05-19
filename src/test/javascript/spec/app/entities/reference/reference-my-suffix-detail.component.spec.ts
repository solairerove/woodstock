import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ReferenceMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/reference/reference-my-suffix-detail.component';
import { ReferenceMySuffixService } from '../../../../../../main/webapp/app/entities/reference/reference-my-suffix.service';
import { ReferenceMySuffix } from '../../../../../../main/webapp/app/entities/reference/reference-my-suffix.model';

describe('Component Tests', () => {

    describe('ReferenceMySuffix Management Detail Component', () => {
        let comp: ReferenceMySuffixDetailComponent;
        let fixture: ComponentFixture<ReferenceMySuffixDetailComponent>;
        let service: ReferenceMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [ReferenceMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ReferenceMySuffixService,
                    EventManager
                ]
            }).overrideComponent(ReferenceMySuffixDetailComponent, {
                set: {
                    template: ''
                }
            }).compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ReferenceMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ReferenceMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ReferenceMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.reference).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
