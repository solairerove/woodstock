#!/usr/bin/python3.4

import time

from py2neo import Graph, Node, Relationship
from py2neo import Path, authenticate

from authenticate import Authenticate
from unit import Unit
from module import Module
from generator import Generator

def main():

    authenticate(Authenticate.HOST_PORT, Authenticate.USER_NAME, Authenticate.USER_PASSWORD)

    graph = Graph()

    graph.delete_all()

    # units
    java = Unit.JAVA_UNIT
    python = Unit.PYTHON_UNIT
    java_script = Unit.JS_UNIT

    # modules
    java_modules = Module.JAVA_MODULES
    python_modules = Module.PYTHON_MODULES
    java_script_modules = Module.JS_MODULES

    generator = Generator()
    generator.generate(java, java_modules, graph)
    generator.generate(python, python_modules, graph)
    generator.generate(java_script, java_script_modules, graph)

    with open('./import.cypher') as file:
        query = file.read()

    print("\n")
    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("\n")
    print("Time to complete:", end)
