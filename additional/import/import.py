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

    string = "Hello World"
    for x in string:
        print(x)

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
    jsf_java = Node("Category", name="JSF")
    spring_framework_java = Node("Category", name="Spring Framework")
    spring_data_jpa_java = Node("Category", name="Spring Data JPA")
    spring_data_mongo_java = Node("Category", name="Spring Data MongoDB")
    spring_data_neo_java = Node("Category", name="Spring Data Neo4J")
    spring_boot_java = Node("Category", name="Spring Boot")

    variables_python = Node("Category", name="Variable types in Python")
    py2neo_python = Node("Category", name="Py2neo Module")

    transaction.create(streams_java)
    transaction.create(primitives_java)
    transaction.create(jsf_java)
    transaction.create(spring_framework_java)
    transaction.create(spring_data_jpa_java)
    transaction.create(spring_data_mongo_java)
    transaction.create(spring_data_neo_java)
    transaction.create(spring_boot_java)

    transaction.create(variables_python)
    transaction.create(py2neo_python)
    # categories end

    # relationships unit<-category start
    java_streams_java = Relationship(streams_java, "HAS_IN", java)
    java_primitives_java = Relationship(primitives_java, "HAS_IN", java)
    java_jsf_java = Relationship(jsf_java, "HAS_IN", java)
    java_spring_framework_java = Relationship(spring_framework_java, "HAS_IN", java)
    java_spring_data_jpa_java = Relationship(spring_data_jpa_java, "HAS_IN", java)
    java_spring_data_mongo_java = Relationship(spring_data_mongo_java, "HAS_IN", java)
    java_spring_data_neo_java = Relationship(spring_data_neo_java, "HAS_IN", java)
    java_spring_boot_java = Relationship(spring_boot_java, "HAS_IN", java)

    python_variables_python = Relationship(variables_python, "HAS_IN", python)
    python_py2neo_python = Relationship(py2neo_python, "HAS_IN", python)

    transaction.create(java_streams_java)
    transaction.create(java_primitives_java)
    transaction.create(java_jsf_java)
    transaction.create(java_spring_framework_java)
    transaction.create(java_spring_data_jpa_java)
    transaction.create(java_spring_data_mongo_java)
    transaction.create(java_spring_data_neo_java)
    transaction.create(java_spring_boot_java)

    transaction.create(python_variables_python)
    transaction.create(python_py2neo_python)
    # relationships unit<-category end

    # task start
    for x in range(0, 15):
        task_java = Node("Task", name="Stream question " + str(x))
        transaction.create(task_java)

        task_streams_java = Relationship(task_java, "HAS_IN", streams_java)
        transaction.create(task_streams_java)

    transaction.commit()

    with open('./import.cypher') as file:
        query = file.read()

    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("Time to complete:", end)
