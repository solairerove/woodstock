package com.github.solairerove.woodstock.controller;

public class ControllerApi {

    public static final String UNIT_API = "/api/units";

    public static final String REFERENCE_API = "/api/units/{unitId}/modules/{moduleId}/references";

    public static final String QUESTION_API = "/api/units/{unitId}/modules/{moduleId}/questions";

    public static final String MODULE_API = "/api/units/{unitId}/modules";

    public static final String CHAPTER_API = "/api/units/{unitId}/modules/{moduleId}/references/{refId}/chapters";

    public static final String ANSWER_API = "/api/units/{unitId}/modules/{moduleId}/questions/{questionId}/answers";
}
