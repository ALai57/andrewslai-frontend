(defproject org.clojars.alai57/andrewslai-frontend "0.0.2-SNAPSHOT"
  :description "Front end for the andrewslai blogging app"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojars.alai57/andrewslai "0.0.44"]
                 [clj-commons/secretary "1.2.4"]
                 [cljs-ajax "0.8.0"]
                 [cljsjs/react "16.13.0-0"]
                 [cljsjs/react-dom "16.13.0-0"]
                 [cljsjs/react-bootstrap "1.0.0-beta.14-0"] ;; latest release
                 [cljsjs/react-pose "1.6.4-1"]
                 [cljsjs/slate "0.33.6-0"]
                 [cljsjs/slate-react "0.12.6-0"]
                 [cljsjs/slate-html-serializer "0.6.3-0"]
                 [org.slf4j/slf4j-nop "1.7.30"]
                 [day8.re-frame/http-fx "0.2.3"]
                 [hickory "0.7.1"]
                 [metosin/spec-tools "0.10.3"]
                 [nubank/matcher-combinators "3.1.4" :scope "test"]
                 [org.clojure/clojurescript "1.10.597"]
                 [org.clojure/core.async "1.0.567"
                  :exclusions [org.clojure/tools.reader]]
                 [re-frame "0.12.0"]
                 [reagent "0.10.0"]
                 [ring "1.8.0"]
                 [com.bhauman/figwheel-main "0.2.12"]
                 [sablono "0.8.6"]
                 [com.taoensso/timbre "4.10.0"]]

  :plugins [[lein-shell "0.5.0"]]

  :clean-targets ^{:protect false} [:target-path "resources/public/js/compiled"]

  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:dev"   ["run" "-m" "figwheel.main" "-bo" "dev"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:prod"  ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "prod"]}

  :profiles
  {:dev {:dependencies [[binaryage/devtools "1.0.0"]
                        [cider/piggieback "0.4.2"]
                        [com.bhauman/cljs-test-display "0.1.1"]
                        [com.bhauman/figwheel-main "0.2.12"]
                        [com.bhauman/rebel-readline-cljs "0.1.4"]
                        [figwheel-sidecar "0.5.19"]
                        [org.clojure/test.check "1.1.0"]]
         :plugins [[lein-ring "0.12.5"]]
         :source-paths ["src/andrewslai/cljs"]
         :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}

   :prod {:dependencies [[com.bhauman/figwheel-main "0.2.12"]]
          :source-paths ["src/andrewslai/cljs"]
          :prep-tasks ["fig:prod" ["shell" "rm" "-rf" "./resources/public/js/compiled/out_prod"]]}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["clean"]
                  ["fig:prod"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
