#!/usr/bin/python3.4

import time

from py2neo import Graph, Node, Relationship
from py2neo import Path, authenticate

def main():

    host_port = 'localhost:7474'
    user_name = 'neo4j'
    user_password = 'woodstock'

    authenticate(host_port, user_name, user_password)

    graph = Graph()
    transaction = graph.begin()

    graph.delete_all()

    java_description = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus suscipit mollis.' \
                       'Vivamus dignissim quis arcu et consectetur. Nulla volutpat ut metus sit amet efficitur. ' \
                       'Donec molestie orci orci, ac scelerisque metus vehicula a.'

    java_reference = 'Ut a nisi sit amet turpis euismod rhoncus. Phasellus hendrerit vel turpis ut condimentum. ' \
                     'Nam cursus turpis id ex sagittis, nec aliquam risus rhoncus. ' \
                     'Vivamus fringilla erat in tincidunt rutrum. ' \
                     'Sed vulputate purus non lorem blandit, ut consectetur eros egestas.'

    python_description = 'Nulla sollicitudin iaculis velit, at ultricies arcu malesuada sed. ' \
                         'Pellentesque eu euismod nunc, in consequat sem. Aliquam pulvinar ante in lobortis faucibus. ' \
                         'Fusce consectetur nibh elit, nec egestas ipsum imperdiet et. ' \
                         'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'

    python_reference = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus suscipit mollis.' \
                     'Vivamus dignissim quis arcu et consectetur. Nulla volutpat ut metus sit amet efficitur. ' \
                     'Donec molestie orci orci, ac scelerisque metus vehicula a.'

    js_description = 'Nulla sollicitudin iaculis velit, at ultricies arcu malesuada sed. ' \
                         'Pellentesque eu euismod nunc, in consequat sem. Aliquam pulvinar ante in lobortis faucibus. ' \
                         'Fusce consectetur nibh elit, nec egestas ipsum imperdiet et. ' \
                         'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'

    js_reference = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus suscipit mollis.' \
                       'Vivamus dignissim quis arcu et consectetur. Nulla volutpat ut metus sit amet efficitur. ' \
                       'Donec molestie orci orci, ac scelerisque metus vehicula a.'

    # units start
    java = Node("Unit", label="Java", description=java_description, reference=java_reference)
    python = Node("Unit", label="Python", description=python_description, reference=python_reference)
    java_script = Node("Unit", label="Java Script", description=js_description, reference=js_reference)

    transaction.create(java)
    transaction.create(python)
    transaction.create(java_script)
    # units end

    java_modules = [
        'Streams in Java',
        'Primitive types in Java',
        'JSF',
        'Spring Framework',
        'Spring Data JPA',
        'Spring Data MongoDB',
        'Spring Data Neo4J',
        'Spring Boot'
    ]

    python_modules = [
        "Some python module 1",
        "Some python module 2"
    ]

    java_script_modules = [
        "Some js module 1",
        "Some js module 2"
    ]

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
