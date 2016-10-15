#!/bin/bash

mkdir /opt/docker/woodstock
mkdir /opt/docker/woodstock/sonar
mkdir /opt/docker/woodstock/neo4j
mkdir /opt/docker/woodstock/neo4j-test
mkdir /opt/docker/woodstock/jenkins

chown -R krivitski-no:users /opt/docker/woodstock
chmod -R 777 /opt/docker/woodstock
