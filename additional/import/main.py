#!/usr/bin/python3.5

import time

from generate.create import Import


def main():
    create = Import()
    create.create()


if __name__ == '__main__':
    start = time.time()
    main()
    end = time.time() - start
    print("\n")
    print("Time to complete:", end)
