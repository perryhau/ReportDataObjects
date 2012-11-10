ReportDataObjects README

This project defines data classes for processing reports and persisting content and meta-data of interest.

Raw content, sentences, term-frequency, named entities and locations are properties of a Report class, annotated with Jackson annotation to enable JSON marshaling.

A graph data model is also provided, to support the use of Neo4j as a persistence store for large scale graphs of reports and their extracted content.