#!/bin/bash

mkdir /docker/woodstock
mkdir /docker/woodstock/sonar
mkdir /docker/woodstock/neo4j
mkdir /docker/woodstock/neo4j-test
mkdir /docker/woodstock/jenkins

chown -R ${USER}:users /docker/woodstock
chmod -R 777 /docker/woodstock
