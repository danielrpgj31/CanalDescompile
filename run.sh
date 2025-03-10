#!/bin/bash

docker stats --format 'Memory: {{.MemUsage}} CPU: {{.CPUPerc}}'