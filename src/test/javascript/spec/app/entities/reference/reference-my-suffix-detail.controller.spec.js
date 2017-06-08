'use strict';

describe('Controller Tests', function() {

    describe('Reference Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockReference, MockChapter, MockModule;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockReference = jasmine.createSpy('MockReference');
            MockChapter = jasmine.createSpy('MockChapter');
            MockModule = jasmine.createSpy('MockModule');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Reference': MockReference,
                'Chapter': MockChapter,
                'Module': MockModule
            };
            createController = function() {
                $injector.get('$controller')("ReferenceMySuffixDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'woodstock24App:referenceUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
