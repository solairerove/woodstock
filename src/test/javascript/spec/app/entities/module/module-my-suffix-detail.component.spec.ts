import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { DateUtils, DataUtils, EventManager } from 'ng-jhipster';
import { WoodstockTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ModuleMySuffixDetailComponent } from '../../../../../../main/webapp/app/components/module/module-my-suffix-detail.component';
import { ModuleMySuffixService } from '../../../../../../main/webapp/app/components/module/module-my-suffix.service';
import { ModuleMySuffix } from '../../../../../../main/webapp/app/components/module/module-my-suffix.model';

describe('Component Tests', () => {

    describe('ModuleMySuffix Management Detail Component', () => {
        let comp: ModuleMySuffixDetailComponent;
        let fixture: ComponentFixture<ModuleMySuffixDetailComponent>;
        let service: ModuleMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WoodstockTestModule],
                declarations: [ModuleMySuffixDetailComponent],
                providers: [
                    DateUtils,
                    DataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ModuleMySuffixService,
                    EventManager
                ]
            }).overrideComponent(ModuleMySuffixDetailComponent, {
                set: {
                    template: ''
                }
            }).compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ModuleMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ModuleMySuffixService);
        });


        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ModuleMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.module).toEqual(jasmine.objectContaining({id:10}));
            });
        });
    });

});
