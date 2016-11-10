#!/usr/bin/python3.4

from py2neo import Node, Relationship

class Generator:

    def generate(self, unit, modules, graph):

        transaction = graph.begin()

        # unit
        transaction.create(unit)

        # module
        for m in modules:
            module = Node("Module", name=m)
            transaction.create(module)

            transaction.create(Relationship(module, "HAS_IN", unit))

            # task
            for x in range(0, 15):
                task = Node("Task", question="Some question " + str(x))
                transaction.create(task)

                transaction.create(Relationship(task, "HAS_IN", module))

                # ticket
                for y in range(0, 10):
                    ticket = Node("Ticket", value="Some ticket" + str(y))
                    transaction.create(ticket)

                    transaction.create(Relationship(ticket, "HAS_IN", task))

        transaction.commit()