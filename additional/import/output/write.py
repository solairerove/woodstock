#!/usr/bin/python3.4

class Write:
    def __init__(self):
        self.path = './import.cypher'

    def write(self, graph):
        with open('./output/import.cypher') as file:
            query = file.read()

        print("\n")
        print(graph.run(query).dump())
