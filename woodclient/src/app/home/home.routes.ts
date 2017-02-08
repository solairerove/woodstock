import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home.component';
import {CounterComponent} from './components/counter/counter.component';
import {ReactiveFormComponent} from './components/reactive-form/reactive-form.component';
import {DynamicEntrypointComponent} from './components/dynamic-entrypoint/dynamic-entrypoint.component';
import {SectionComponent} from './components/section/section.component';

const routes: Routes = [
    {
        path: 'home', component: HomeComponent, canActivate: [],
        children: [
            { path: 'counter', component: CounterComponent, canActivate: [] },
            { path: 'reactive-form', component: ReactiveFormComponent, canActivate: [] },
            { path: 'dynamic-entrypoint-component', component: DynamicEntrypointComponent, canActivate: [] },
            { path: 'section', component: SectionComponent, canActivate: [] }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HomeRoutingModule {

}
