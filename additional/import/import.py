#!/usr/bin/python3.4

import time
from py2neo import Graph

def main():

    host_port = "localhost:7474"
    user_name = "neo4j"
    password = "woodstock"

    graph = Graph("http://" + user_name + ":" + password + "@" + host_port + "/db/data/")

    query = '''
        MATCH (n) RETURN n LIMIT 200
    '''

    print(graph.run(query).dump())

if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("Time to complete:", end)
