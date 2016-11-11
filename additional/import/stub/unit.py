#!/usr/bin/python3.4

from py2neo import Node

from .description import Description


class Unit:
    JAVA_UNIT = Node("Unit", label="Java", description=Description.JAVA_DESCRIPTION)

    PYTHON_UNIT = Node("Unit", label="Python", description=Description.PYTHON_DESCRIPTION)

    JS_UNIT = Node("Unit", label="Java Script", description=Description.JS_DESCRIPTION)
