#!/usr/bin/python3.4

from py2neo import Node

from .description import Description
from .reference import Reference


class Unit:
    JAVA_UNIT = Node("Unit", label="Java", description=Description.JAVA_DESCRIPTION, reference=Reference.JAVA_REFERENCE)

    PYTHON_UNIT = Node("Unit", label="Python", description=Description.PYTHON_DESCRIPTION,
                       reference=Reference.PYTHON_REFERENCE)

    JS_UNIT = Node("Unit", label="Java Script", description=Description.JS_DESCRIPTION,
                   reference=Reference.JS_REFERENCE)
