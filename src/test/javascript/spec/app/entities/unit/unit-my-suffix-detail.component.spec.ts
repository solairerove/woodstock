import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { UnitMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/unit/unit-my-suffix-detail.component';
import { UnitMySuffixService } from '../../../../../../main/webapp/app/entities/unit/unit-my-suffix.service';
import { UnitMySuffix } from '../../../../../../main/webapp/app/entities/unit/unit-my-suffix.model';

describe('Component Tests', () => {

    describe('UnitMySuffix Management Detail Component', () => {
        let comp: UnitMySuffixDetailComponent;
        let fixture: ComponentFixture<UnitMySuffixDetailComponent>;
        let service: UnitMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [UnitMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    UnitMySuffixService,
                    EventManager
                ]
            }).overrideTemplate(UnitMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UnitMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UnitMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new UnitMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.unit).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
