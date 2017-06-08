'use strict';

describe('Controller Tests', function() {

    describe('Module Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockModule, MockUnit, MockReference, MockQuestion;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockModule = jasmine.createSpy('MockModule');
            MockUnit = jasmine.createSpy('MockUnit');
            MockReference = jasmine.createSpy('MockReference');
            MockQuestion = jasmine.createSpy('MockQuestion');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Module': MockModule,
                'Unit': MockUnit,
                'Reference': MockReference,
                'Question': MockQuestion
            };
            createController = function() {
                $injector.get('$controller')("ModuleMySuffixDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'woodstock24App:moduleUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
