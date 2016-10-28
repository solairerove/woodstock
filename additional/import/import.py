#!/usr/bin/python3.4

import time

from py2neo import Graph
from py2neo import Path, authenticate

def main():

    host_port = 'localhost:7474'
    user_name = 'neo4j'
    user_password = 'woodstock'

    authenticate(host_port, user_name, user_password)

    graph = Graph()

    with open('./import.cypher') as file:
        query = file.read()

    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("Time to complete:", end)
