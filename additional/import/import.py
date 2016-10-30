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

    # tasks start
    task1_java = Node("Task", name="Stream question 1")
    task2_java = Node("Task", name="Stream question 2")
    task3_java = Node("Task", name="Stream question 3")
    task4_java = Node("Task", name="Stream question 4")
    task5_java = Node("Task", name="Stream question 5")
    task6_java = Node("Task", name="Stream question 6")
    task7_java = Node("Task", name="Stream question 7")
    task8_java = Node("Task", name="Stream question 8")
    task9_java = Node("Task", name="Stream question 9")
    task10_java = Node("Task", name="Stream question 10")
    task11_java = Node("Task", name="Stream question 11")
    task12_java = Node("Task", name="Stream question 12")
    task13_java = Node("Task", name="Stream question 13")
    task14_java = Node("Task", name="Stream question 14")
    task15_java = Node("Task", name="Stream question 15")

    transaction.create(task1_java)
    transaction.create(task2_java)
    transaction.create(task3_java)
    transaction.create(task4_java)
    transaction.create(task5_java)
    transaction.create(task6_java)
    transaction.create(task7_java)
    transaction.create(task8_java)
    transaction.create(task9_java)
    transaction.create(task10_java)
    transaction.create(task11_java)
    transaction.create(task12_java)
    transaction.create(task13_java)
    transaction.create(task14_java)
    transaction.create(task15_java)
    # tasks end

    # relationships category<-task start
    task1_streams_java = Relationship(task1_java, "HAS_IN", streams_java)
    task2_streams_java = Relationship(task2_java, "HAS_IN", streams_java)
    task3_streams_java = Relationship(task3_java, "HAS_IN", streams_java)
    task4_streams_java = Relationship(task4_java, "HAS_IN", streams_java)
    task5_streams_java = Relationship(task5_java, "HAS_IN", streams_java)
    task6_streams_java = Relationship(task6_java, "HAS_IN", streams_java)
    task7_streams_java = Relationship(task7_java, "HAS_IN", streams_java)
    task8_streams_java = Relationship(task8_java, "HAS_IN", streams_java)
    task9_streams_java = Relationship(task9_java, "HAS_IN", streams_java)
    task10_streams_java = Relationship(task10_java, "HAS_IN", streams_java)
    task11_streams_java = Relationship(task11_java, "HAS_IN", streams_java)
    task12_streams_java = Relationship(task12_java, "HAS_IN", streams_java)
    task13_streams_java = Relationship(task13_java, "HAS_IN", streams_java)
    task14_streams_java = Relationship(task14_java, "HAS_IN", streams_java)
    task15_streams_java = Relationship(task15_java, "HAS_IN", streams_java)

    transaction.create(task1_streams_java)
    transaction.create(task2_streams_java)
    transaction.create(task3_streams_java)
    transaction.create(task4_streams_java)
    transaction.create(task5_streams_java)
    transaction.create(task6_streams_java)
    transaction.create(task7_streams_java)
    transaction.create(task8_streams_java)
    transaction.create(task9_streams_java)
    transaction.create(task10_streams_java)
    transaction.create(task11_streams_java)
    transaction.create(task12_streams_java)
    transaction.create(task13_streams_java)
    transaction.create(task14_streams_java)
    transaction.create(task15_streams_java)
    # relationships category<-task end

    transaction.commit()

    with open('./import.cypher') as file:
        query = file.read()

    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("Time to complete:", end)
