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

    # categories start
    streams_java = Node("Category", name="Streams in Java")
    primitives_java = Node("Category", name="Primitive types in Java")

    variables_python = Node("Category", name="Variable types in Python")

    transaction.create(streams_java)
    transaction.create(primitives_java)
    transaction.create(variables_python)
    # categories end

    # relationships start
    java_streams_java = Relationship(streams_java, "HAS_IN", java)
    java_primitives_java = Relationship(primitives_java, "HAS_IN", java)

    python_variables_python = Relationship(variables_python, "HAS_IN", python)

    transaction.create(java_streams_java)
    transaction.create(java_primitives_java)
    transaction.create(python_variables_python)
    # relationships end

    transaction.commit()

    with open('./import.cypher') as file:
        query = file.read()

    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("Time to complete:", end)
