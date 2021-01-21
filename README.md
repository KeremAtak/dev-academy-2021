# dev-academy-2021

![lisp_cycles](./resources/public/img/lisp_cycles.png)

[https://xkcd.com/297/](https://xkcd.com/297/)


[![CircleCI](https://circleci.com/gh/KeremAtak/dev-academy-2021.svg?style=svg)](https://app.circleci.com/pipelines/github/KeremAtak/dev-academy-2021)

This repository contains the solution for Solita's dev academy assignment. The base files for this project were generated with (not-so-finished) [atak-clj](https://github.com/KeremAtak/atak-clj) template, which itself is a modified [Luminus](https://luminusweb.com/) template.

## Installation

Make sure that you have Java and [Leiningen](https://leiningen.org/) installed.

## Usage

Ensure that the port 3000 is open. Start the project with `lein run`, dependencies are installed when doing this for the first time. Once running you can use the project in browser at [http://localhost:3000/swagger-ui/index.html#/](http://localhost:3000/swagger-ui/index.html#/).

You can try each end point by opening the block, then clicking "Try it out", and finally "Execute". `/api/names/count-by-name` requires you to insert the parameter.

On your terminal you can run the tests with `lein test-refresh`, or with `lein test` if you want to run them just once.

## Technologies used

**Clojure** is more often than not a great choice for any project. And people at Solita know this fact very well. For parsing data using Clojure is just a pleasure to work with.

**Reitit** is a great choice for routing needs. It has a clear syntax and plenty of options. For example I implemented schemas with clojure.spec, validating the requests and responses. Not to mention that Reitit [is very fast.](https://github.com/metosin/reitit/blob/master/doc/performance.md)

For web API development **Swagger-ui** covers just about all of your UI needs. Its UI is clear, you can smartly categorize and document your end points, and it shows everything that you need to know about your end points.

With a simple **CircleCI** setup development becomes much less stressful; checking that the build passes before merging feature branch to main greatly reduces the risk of human error. Linters that are run with CircleCI could be implemented but I have decided it's outside of the scope of this project.

## Misc

**names.json** is located under `/resources/public/json`.
