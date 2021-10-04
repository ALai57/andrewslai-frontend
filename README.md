# andrewslai-frontend

Clojurescript Frontend for `andrewslai`

This repository is the website frontend. It contains:

- **Front end**: Re-frame SPA written in Clojurescript  

## Installation/setup
Clone the repo and install [leiningen](https://leiningen.org/).  

## Tests
```bash
lein fig:repl
```
then navigate to `/tests.html` to see test output

## Builds
The app is built using `figwheel-main`  

#### Build: Not minimized
To build the project without any Google Closure optimizations, use   
```bash
lein fig:dev
```
(this will also connect a figwheel REPL for interactive development)

#### Build: Minimized, dev
```bash
lein fig:min
```

#### Build: Minimized, prod
```bash
lein fig:prod
```

## Development

#### Interactive development with locally-running backend
```bash
lein fig:repl
```
