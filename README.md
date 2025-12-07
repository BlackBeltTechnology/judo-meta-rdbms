# judo-meta-rdbms

[![Build](https://github.com/BlackBeltTechnology/judo-meta-rdbms/actions/workflows/build.yml/badge.svg?branch=develop)](https://github.com/BlackBeltTechnology/judo-meta-rdbms/actions/workflows/build.yml)

## Introduction

This repository contains the RDBMS meta model.

It acts as an eclipse plugin with features and sites, can be used standalone and in standard OSGi (without eclipse).

Used for Liquibase (DDL) generation. Describes e.g.: tables, views, keys, etc.

## Context

This project is a building block of the [judo-community](https://github.com/BlackBeltTechnology/judo-community) aggregator project. In order to better understand how this module fits into our ecosystem, please check the corresponding documentation!

## Contributing to the project

Everyone is welcome to contribute to JUDO! As a starter, please read the corresponding [CONTRIBUTING](CONTRIBUTING.md) guide for details!

## Validation

The RDBMS metamodel supports dual validation:

* **EVL (Epsilon Validation Language)**: Located in `model/src/main/epsilon/validations/`
* **Java (Zeta Framework)**: Located in `model/src/main/java/hu/blackbelt/judo/meta/rdbms/validation/`

Both implementations produce identical results and can be run via parameterized tests.

For detailed documentation, see [Validation Documentation](docs/validation/README.md).

## License

This project is licensed under the [Eclipse Public License - v 2.0](https://www.eclipse.org/legal/epl-2.0/).
