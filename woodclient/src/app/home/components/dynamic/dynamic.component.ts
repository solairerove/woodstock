import { Component, OnInit, ViewChild, ViewContainerRef, ComponentFactoryResolver, Input, ReflectiveInjector } from '@angular/core';

import { FirstDumbComponent } from '../first-dumb/first-dumb.component';
import { SecondDumbComponent } from '../second-dumb/second-dumb.component';

@Component({
  selector: 'app-dynamic',
  entryComponents: [FirstDumbComponent, SecondDumbComponent],
  template: `<div #dynamicComponentContainer></div>`
})
export class DynamicComponent implements OnInit {

  currentComponent = null;

  @ViewChild('dynamicComponentContainer', { read: ViewContainerRef }) dynamicComponentContainer: ViewContainerRef;

  constructor(private resolver: ComponentFactoryResolver) { }

  ngOnInit() {
  }

  @Input() set componentData(data: { component: any, inputs: any }) {
    if (!data) {
      return;
    }

    let inputProviders = Object.keys(data.inputs).map((inputName) => { return { provide: inputName, useValue: data.inputs[inputName] }; });
    let resolvedInputs = ReflectiveInjector.resolve(inputProviders);

    let injector = ReflectiveInjector.fromResolvedProviders(resolvedInputs, this.dynamicComponentContainer.parentInjector);

    let factory = this.resolver.resolveComponentFactory(data.component);

    let component = factory.create(injector);

    this.dynamicComponentContainer.insert(component.hostView);

    if (this.currentComponent) {
      this.currentComponent.destroy();
    }

    this.currentComponent = component;
  }
}
