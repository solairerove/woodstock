#!/usr/bin/python3.4

import time

from py2neo import Graph, Node, Relationship
from py2neo import Path, authenticate

from authenticate import Authenticate
from unit import Unit
from module import Module

def main():

    authenticate(Authenticate.HOST_PORT, Authenticate.USER_NAME, Authenticate.USER_PASSWORD)

    graph = Graph()
    transaction = graph.begin()

    graph.delete_all()

    # units start
    java = Unit.JAVA_UNIT
    python = Unit.PYTHON_UNIT
    java_script = Unit.JS_UNIT

    transaction.create(java)
    transaction.create(python)
    transaction.create(java_script)
    # units end

    java_modules = Module.JAVA_MODULES
    python_modules = Module.PYTHON_MODULES
    java_script_modules = Module.JS_MODULES

    # module java
    for module in java_modules:
        module_java = Node("Module", name=module)
        transaction.create(module_java)

        transaction.create(Relationship(module_java, "HAS_IN", java))

        # task java
        for x in range(0, 15):
            task_java = Node("Task", question="Some question " + str(x))
            transaction.create(task_java)

            transaction.create(Relationship(task_java, "HAS_IN", module_java))

            # ticket java
            for y in range(0, 10):
                ticket_java = Node("Ticket", value="Some ticket" + str(y))
                transaction.create(ticket_java)

                transaction.create(Relationship(ticket_java, "HAS_IN", task_java))

    # module python
    for module in python_modules:
        module_python = Node("Module", name=module)
        transaction.create(module_python)

        transaction.create(Relationship(module_python, "HAS_IN", python))

        # task python
        for x in range(0, 15):
            task_python = Node("Task", question="Some question " + str(x))
            transaction.create(task_python)

            transaction.create(Relationship(task_python, "HAS_IN", module_python))

            # ticket python
            for y in range(0, 10):
                ticket_python = Node("Ticket", value="Some ticket" + str(y))
                transaction.create(ticket_python)

                transaction.create(Relationship(ticket_python, "HAS_IN", task_python))


    # module js
    for module in java_script_modules:
        module_js = Node("Module", name=module)
        transaction.create(module_js)

        transaction.create(Relationship(module_js, "HAS_IN", java_script))

        # task js
        for x in range(0, 15):
            task_js = Node("Task", question="Some question " + str(x))
            transaction.create(task_js)

            transaction.create(Relationship(task_js, "HAS_IN", module_js))

            # ticket js
            for y in range(0, 10):
                ticket_js = Node("Ticket", value="Some ticket" + str(y))
                transaction.create(ticket_js)

                transaction.create(Relationship(ticket_js, "HAS_IN", task_js))

    transaction.commit()

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
