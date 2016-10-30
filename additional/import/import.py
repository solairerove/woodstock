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

    categories = [
        'Streams in Java',
        'Primitive types in Java',
        'JSF',
        'Spring Framework',
        'Spring Data JPA',
        'Spring Data MongoDB',
        'Spring Data Neo4J',
        'Spring Boot'
    ]

    # category
    for category in categories:
        print(category)

        node = Node("Category", name=category)
        transaction.create(node)

        transaction.create(Relationship(node, "HAS_IN", java))

        # task
        for x in range(0, 15):
            task_java = Node("Task", name="Some question " + str(x))
            transaction.create(task_java)

            task_streams_java = Relationship(task_java, "HAS_IN", node)
            transaction.create(task_streams_java)

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
