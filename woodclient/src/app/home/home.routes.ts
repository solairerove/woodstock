import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { CounterComponent } from './components/counter/counter.component';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';

const routes: Routes = [
    {
        path: 'home', component: HomeComponent, canActivate: [],
        children: [
            { path: 'counter', component: CounterComponent, canActivate: [] },
            { path: 'reactive-form', component: ReactiveFormComponent, canActivate: [] }
        ]
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HomeRoutingModule {

}
