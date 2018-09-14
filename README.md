# Object Relational Mapping with JPA

Explain the rationale behind the topic Object Relational Mapping and the Pros and Cons in using ORM:
Pros
* Facilitates implementing domain model pattern.
* Huge reduction in code.
* Takes care of vendor specific code by itself.
* Cache Management — Entities are cached in memory thereby reducing load on the DB.
* Huge reduction in product-to-client time

Cons
* Increased startup time due to metadata preparation( not good for desktop applications).
* Huge learning curve without ORM.
* Relatively hard to fine tune and debug generated SQL. Not suitable for applications without a clean domain object model.

Explain the JPA strategy for handling Object Relational Mapping and important classes/annotations involved:

* Idiomatic persistence : It enables you to write the persistence classes using object oriented classes.
* High Performance : It has many fetching techniques and hopeful locking techniques.
* Reliable : It is highly stable and eminent. Used by many industrial programmers.

Outline some of the fundamental differences in Database handling using plain JDBC versus JPA:

* No need to setup connector and handle JDBC setup
* Far less code
* JPA opens up for an easy and efficient way of handling mapping
