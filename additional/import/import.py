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

    # units start
    java = Node("Unit", label="Java")
    python = Node("Unit", label="Python")

    transaction.create(java)
    transaction.create(python)
    # units end

    java_categories = [
        'Streams in Java',
        'Primitive types in Java',
        'JSF',
        'Spring Framework',
        'Spring Data JPA',
        'Spring Data MongoDB',
        'Spring Data Neo4J',
        'Spring Boot'
    ]

    python_categories = [
        "Some python category 1",
        "Some python category 2"
    ]

    # category java
    for category in java_categories:
        category_java = Node("Category", name=category)
        transaction.create(category_java)

        transaction.create(Relationship(category_java, "HAS_IN", java))

        # task java
        for x in range(0, 15):
            task_java = Node("Task", question="Some question " + str(x))
            transaction.create(task_java)

            transaction.create(Relationship(task_java, "HAS_IN", category_java))

            # ticket java
            for y in range(0, 10):
                ticket_java = Node("Ticket", value="Some ticket" + str(y))
                transaction.create(ticket_java)

                transaction.create(Relationship(ticket_java, "HAS_IN", task_java))

    # category python
    for category in python_categories:
        category_python = Node("Category", name=category)
        transaction.create(category_python)

        transaction.create(Relationship(category_python, "HAS_IN", python))

        # task python
        for x in range(0, 15):
            task_python = Node("Task", question="Some question " + str(x))
            transaction.create(task_python)

            transaction.create(Relationship(task_python, "HAS_IN", category_python))

            # ticket python
            for y in range(0, 10):
                ticket_python = Node("Ticket", value="Some ticket" + str(y))
                transaction.create(ticket_python)

                transaction.create(Relationship(ticket_python, "HAS_IN", task_python))

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
