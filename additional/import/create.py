#!/usr/bin/python3.4

from py2neo import Graph
from py2neo import Path, authenticate

from authenticate import Authenticate
from unit import Unit
from module import Module
from generator import Generator


class Import:
    def create(self):
        authenticate(Authenticate.HOST_PORT, Authenticate.USER_NAME, Authenticate.USER_PASSWORD)

        graph = Graph()

        graph.delete_all()

        generator = Generator()
        generator.generate(Unit.JAVA_UNIT, Module.JAVA_MODULES, graph)
        generator.generate(Unit.PYTHON_UNIT, Module.PYTHON_MODULES, graph)
        generator.generate(Unit.JS_UNIT, Module.JS_MODULES, graph)
